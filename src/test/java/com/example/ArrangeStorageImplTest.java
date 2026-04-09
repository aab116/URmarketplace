package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrangeStorageImplTest {

    private ArrangeStorageImpl storage;

    @BeforeEach
    void setUp() {
        // Create a fresh storage object before each test so tests do not affect each
        // other.
        storage = new ArrangeStorageImpl();
    }

    @Test
    void requestStorageCreatesActiveBookingWithGeneratedId() {
        // Request storage for one item and keep the returned booking id.
        String bookingId = storage.requestStorage("item-101", "user-9", 5, 2.5);

        // The booking id should exist and should not be blank.
        assertNotNull(bookingId);
        assertFalse(bookingId.isBlank());

        // A brand new booking should be marked active right away.
        assertTrue(storage.isActive(bookingId));
    }

    @Test
    void cancelStorageSucceedsOnceAndThenFails() {
        // First create a valid booking.
        String bookingId = storage.requestStorage("item-101", "user-9", 5, 2.5);

        // The first cancel should work.
        assertTrue(storage.cancelStorage(bookingId));

        // After cancelling, the booking should no longer be active.
        assertFalse(storage.isActive(bookingId));

        // Cancelling the same booking again should fail because it is already
        // cancelled.
        assertFalse(storage.cancelStorage(bookingId));
    }

    @Test
    void cancelStorageReturnsFalseForNullOrUnknownId() {
        // Null ids and random ids should not cancel anything.
        assertFalse(storage.cancelStorage(null));
        assertFalse(storage.cancelStorage("does-not-exist"));
    }

    @Test
    void calculateStorageFeeReturnsDaysTimesRate() {
        // 5 days at 2.5 per day should cost 12.5 total.
        assertEquals(12.5, storage.calculateStorageFee(5, 2.5), 0.0001);
    }

    @Test
    void calculateStorageFeeRejectsInvalidInputs() {
        // Zero or negative days should be rejected.
        assertThrows(IllegalArgumentException.class, () -> storage.calculateStorageFee(0, 2.5));
        assertThrows(IllegalArgumentException.class, () -> storage.calculateStorageFee(-1, 2.5));

        // Negative rates should also be rejected.
        assertThrows(IllegalArgumentException.class, () -> storage.calculateStorageFee(5, -0.01));
    }

    @Test
    void requestStorageRejectsInvalidInputs() {
        // Bad item ids should fail.
        assertThrows(IllegalArgumentException.class, () -> storage.requestStorage(null, "user-9", 5, 1.0));
        assertThrows(IllegalArgumentException.class, () -> storage.requestStorage("   ", "user-9", 5, 1.0));

        // Bad user ids should fail.
        assertThrows(IllegalArgumentException.class, () -> storage.requestStorage("item-1", null, 5, 1.0));
        assertThrows(IllegalArgumentException.class, () -> storage.requestStorage("item-1", "  ", 5, 1.0));

        // Invalid day counts and negative rates should fail too.
        assertThrows(IllegalArgumentException.class, () -> storage.requestStorage("item-1", "user-1", 0, 1.0));
        assertThrows(IllegalArgumentException.class, () -> storage.requestStorage("item-1", "user-1", 5, -1.0));
    }

    @Test
    void isActiveReturnsFalseForNullOrUnknownId() {
        // Unknown bookings should not be active.
        assertFalse(storage.isActive(null));
        assertFalse(storage.isActive("missing"));
    }

    @Test
    void getActiveStorageFeeForItemReturnsOnlyActiveFeesForMatchingItem() {
        // Two bookings for the same item
        String booking1 = storage.requestStorage("item-101", "user-9", 5, 2.0); // 10.0
        String booking2 = storage.requestStorage("item-101", "user-9", 3, 4.0); // 12.0

        // One booking for a different item
        storage.requestStorage("item-999", "user-9", 10, 1.0); // should not count

        // Cancel one booking so only one active booking remains for item-101
        storage.cancelStorage(booking1);

        double fee = storage.getActiveStorageFeeForItem("item-101");

        // Only booking2 should count
        assertEquals(12.0, fee, 0.0001);
    }

    @Test
    void getActiveStorageFeeForItemReturnsZeroWhenNoActiveBookingExists() {
    assertEquals(0.0, storage.getActiveStorageFeeForItem("missing-item"), 0.0001);
}
}
