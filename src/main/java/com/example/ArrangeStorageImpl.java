package com.example;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * ArrangeStorageImpl
 * ------------------
 * In-memory implementation of ArrangeStorage.
 *
 * Notes:
 * - Stores bookings in a map.
 * - Your group can swap this later to database storage without changing callers
 *   (because callers only use the interface).
 */
public class ArrangeStorageImpl implements ArrangeStorage {

    /**
     * Storage record (kept private so you don't "own" the domain model).
     * This is just internal bookkeeping for this implementation.
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

    // In-memory "database"
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

        // Create booking ID
        String storageId = UUID.randomUUID().toString();

        // Store booking record
        StorageRecord record = new StorageRecord(storageId, itemId.trim(), requesterUserId.trim(), days, dailyRate);
        bookings.put(storageId, record);

        return storageId;
    }

    @Override
    public boolean cancelStorage(String storageBookingId) {
        if (storageBookingId == null) return false;

        StorageRecord record = bookings.get(storageBookingId);
        if (record == null) return false;

        // If already cancelled/inactive, do nothing
        if (!record.active) return false;

        record.active = false;
        return true;
    }

    @Override
    public double calculateStorageFee(int days, double dailyRate) {
        if (days <= 0) throw new IllegalArgumentException("days must be > 0.");
        if (dailyRate < 0) throw new IllegalArgumentException("dailyRate cannot be negative.");
        return days * dailyRate;
    }

    @Override
    public boolean isActive(String storageBookingId) {
        if (storageBookingId == null) return false;
        StorageRecord record = bookings.get(storageBookingId);
        return record != null && record.active;
    }
}