package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class OfferTest {

    @Test
    void constructorInitializesOfferState() {
        // Capture the time before and after construction to verify the timestamp.
        LocalDateTime before = LocalDateTime.now();
        Offer offer = new Offer(5, "bidder1", 250.0);
        LocalDateTime after = LocalDateTime.now();

        // The constructor should copy the main fields.
        assertEquals(5, offer.getListingId());
        assertEquals("bidder1", offer.getBidderUsername());
        assertEquals(250.0, offer.getAmount(), 0.0001);

        // New offers should start pending.
        assertEquals("PENDING", offer.getStatus());

        // The timestamp should be created automatically during construction.
        assertNotNull(offer.getTimestamp());
        assertFalse(offer.getTimestamp().isBefore(before));
        assertFalse(offer.getTimestamp().isAfter(after));
    }

    @Test
    void settersAndGettersRoundTripValues() {
        // Start with one offer, then change every field manually.
        Offer offer = new Offer(1, "start", 10.0);
        LocalDateTime customTime = LocalDateTime.of(2026, 2, 2, 8, 30);

        offer.setId(42);
        offer.setListingId(99);
        offer.setBidderUsername("newBidder");
        offer.setAmount(500.0);
        offer.setTimestamp(customTime);
        offer.setStatus("ACCEPTED");

        // Every getter should return the value that was set.
        assertEquals(42, offer.getId());
        assertEquals(99, offer.getListingId());
        assertEquals("newBidder", offer.getBidderUsername());
        assertEquals(500.0, offer.getAmount(), 0.0001);
        assertEquals(customTime, offer.getTimestamp());
        assertEquals("ACCEPTED", offer.getStatus());
    }
}
