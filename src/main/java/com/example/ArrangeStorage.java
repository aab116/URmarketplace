package com.example;

/**
 * ArrangeStorage
 * --------------
 * Contract for temporary storage services.
 *
 * IMPORTANT FOR GROUP WORK:
 * - Uses IDs (String) instead of User/Item objects.
 * - Your teammates can implement persistence later.
 */
public interface ArrangeStorage {

    /**
     * Request storage for an item.
     *
     * @param itemId the listing/item identifier
     * @param requesterUserId the user requesting storage (usually the seller)
     * @param days number of days to store
     * @param dailyRate cost per day
     * @return storageBookingId unique booking identifier
     */
    String requestStorage(String itemId, String requesterUserId, int days, double dailyRate);

    /**
     * Cancel a storage booking.
     *
     * @param storageBookingId booking identifier
     * @return true if cancelled, false if not found or already cancelled
     */
    boolean cancelStorage(String storageBookingId);

    /**
     * Calculates storage cost.
     */
    double calculateStorageFee(int days, double dailyRate);

    /**
     * Returns whether a booking is currently active.
     */
    boolean isActive(String storageBookingId);
}