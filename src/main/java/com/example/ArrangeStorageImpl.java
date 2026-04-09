package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * ArrangeStorageImpl
 * In-memory implementation of ArrangeStorage.
 *
 * Notes:
 * - Stores bookings in a map.
 * - Your group can swap this later to database storage without changing callers
 *   (because callers only use the interface).
 */
public class ArrangeStorageImpl implements ArrangeStorage {

    /**
     * Storage record
     */
    private static class StorageRecord {
        String storageId;
        String itemId;
        String requesterUserId;
        int days;
        double dailyRate;
        boolean active;

        StorageRecord(String storageId, String itemId, String requesterUserId, int days, double dailyRate) {
            this.storageId = storageId;
            this.itemId = itemId;
            this.requesterUserId = requesterUserId;
            this.days = days;
            this.dailyRate = dailyRate;
            this.active = true;
        }
    }

    // In-memory storage records
    private final Map<String, StorageRecord> bookings = new HashMap<>();

    @Override
    public String requestStorage(String itemId, String requesterUserId, int days, double dailyRate) {
        // Validate inputs
        if (itemId == null || itemId.trim().isEmpty()) {
            throw new IllegalArgumentException("itemId cannot be blank.");
        }
        if (requesterUserId == null || requesterUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("requesterUserId cannot be blank.");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("days must be > 0.");
        }
        if (dailyRate < 0) {
            throw new IllegalArgumentException("dailyRate cannot be negative.");
        }

        // Create a booking id
        String storageId = UUID.randomUUID().toString();

        // Save the booking
        StorageRecord record = new StorageRecord(storageId, itemId.trim(), requesterUserId.trim(), days, dailyRate);
        bookings.put(storageId, record);

        return storageId;
    }

    @Override
    public boolean cancelStorage(String storageBookingId) {
        if (storageBookingId == null) {
            return false;
        }

        StorageRecord record = bookings.get(storageBookingId);
        if (record == null) {
            return false;
        }

        if (!record.active) {
            return false;
        }

        record.active = false;
        return true;
    }

    @Override
    public double calculateStorageFee(int days, double dailyRate) {
        if (days <= 0) {
            throw new IllegalArgumentException("days must be > 0.");
        }
        if (dailyRate < 0) {
            throw new IllegalArgumentException("dailyRate cannot be negative.");
        }
        return days * dailyRate;
    }

    @Override
    public boolean isActive(String storageBookingId) {
        if (storageBookingId == null) {
            return false;
        }

        StorageRecord record = bookings.get(storageBookingId);
        return record != null && record.active;
    }

    @Override
    public double getActiveStorageFeeForItem(String itemId) {
        if (itemId == null || itemId.trim().isEmpty()) {
            throw new IllegalArgumentException("itemId cannot be blank.");
        }

        String cleanedItemId = itemId.trim();
        double totalFee = 0.0;

        // Sum all active storage bookings for this item
        for (StorageRecord record : bookings.values()) {
            if (record.active && cleanedItemId.equals(record.itemId)) {
                totalFee += calculateStorageFee(record.days, record.dailyRate);
            }
        }

        return totalFee;
    }
}