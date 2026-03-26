package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class ListingTest {

    @Test
    void constructorInitializesExpectedDefaults() {
        // Capture the time before and after construction so we can check the auction end time window.
        LocalDateTime before = LocalDateTime.now();
        Listing listing = new Listing("Bike", "Good condition", "seller1", 120.0, "Sports", true);
        LocalDateTime after = LocalDateTime.now();

        // Basic text and numeric fields should match the constructor input.
        assertEquals("Bike", listing.getTitle());
        assertEquals("Good condition", listing.getDescription());
        assertEquals("seller1", listing.getSellerUsername());
        assertEquals(120.0, listing.getStartingPrice(), 0.0001);

        // A new listing should start with current bid equal to the starting price.
        assertEquals(120.0, listing.getCurrentBid(), 0.0001);

        assertEquals("Sports", listing.getCategory());
        assertTrue(listing.isAuction());

        // New listings should begin active and have no highest bidder yet.
        assertEquals("ACTIVE", listing.getStatus());
        assertNull(listing.getHighestBidder());

        // The constructor should set an end time.
        assertNotNull(listing.getEndTime());

        // The end time should be about 7 days from now.
        assertFalse(listing.getEndTime().isBefore(before.plusDays(7).minusSeconds(2)));
        assertFalse(listing.getEndTime().isAfter(after.plusDays(7).plusSeconds(2)));
    }

    @Test
    void settersAndGettersRoundTripValues() {
        // Create an empty listing and set every field manually.
        Listing listing = new Listing();
        LocalDateTime end = LocalDateTime.of(2026, 1, 1, 12, 0);

        listing.setId(10);
        listing.setTitle("Laptop");
        listing.setDescription("16GB RAM");
        listing.setSellerUsername("seller2");
        listing.setStartingPrice(300.0);
        listing.setCurrentBid(355.0);
        listing.setHighestBidder("buyer1");
        listing.setEndTime(end);
        listing.setCategory("Electronics");
        listing.setStatus("SOLD");
        listing.setAuction(false);
        listing.setBuyNowPrice(400.0);

        // Every getter should return the exact value that was set.
        assertEquals(10, listing.getId());
        assertEquals("Laptop", listing.getTitle());
        assertEquals("16GB RAM", listing.getDescription());
        assertEquals("seller2", listing.getSellerUsername());
        assertEquals(300.0, listing.getStartingPrice(), 0.0001);
        assertEquals(355.0, listing.getCurrentBid(), 0.0001);
        assertEquals("buyer1", listing.getHighestBidder());
        assertEquals(end, listing.getEndTime());
        assertEquals("Electronics", listing.getCategory());
        assertEquals("SOLD", listing.getStatus());
        assertFalse(listing.isAuction());
        assertEquals(400.0, listing.getBuyNowPrice(), 0.0001);
    }
}
