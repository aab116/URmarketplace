package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BiddingManagerPathTest {

    private BiddingManager biddingManager;

    @BeforeEach
    void setUp() {
        // Reset the database before each test so every path starts clean
        TestDatabaseUtil.resetAllTables();
        biddingManager = new BiddingManager();
    }

    @Test
    void path1_listingDoesNotExist_returnsMinus1() {
        // Path 1:
        // listing does not exist
        // expected result = -1

        int result = biddingManager.makeOffer(999999, "buyer1", 50.0);

        assertEquals(-1, result);
    }

    @Test
    void path2_listingExistsButNotActive_returnsMinus2() {
        // Create a real listing first
        int listingId = biddingManager.createListing(
                "Desk Lamp",
                "Small lamp",
                "seller1",
                25.0,
                "Furniture",
                true
        );

        // Force it into a non-active state
        TestDatabaseUtil.execute("UPDATE listings SET status = 'SOLD' WHERE id = " + listingId);

        // Path 2:
        // listing exists but is not ACTIVE
        // expected result = -2

        int result = biddingManager.makeOffer(listingId, "buyer1", 40.0);

        assertEquals(-2, result);
    }

    @Test
    void path3_listingIsActiveButBidTooLow_returnsMinus3() {
        // Create an ACTIVE listing with currentBid = 25.0
        int listingId = biddingManager.createListing(
                "Desk Lamp",
                "Small lamp",
                "seller1",
                25.0,
                "Furniture",
                true
        );

        // Path 3:
        // listing exists, is ACTIVE, but bid is too low or equal
        // expected result = -3

        int result = biddingManager.makeOffer(listingId, "buyer1", 25.0);

        assertEquals(-3, result);
    }

    @Test
    void path4_listingIsActiveAndBidIsHigher_returns1AndUpdatesDatabase() {
        // Create an ACTIVE listing with currentBid = 25.0
        int listingId = biddingManager.createListing(
                "Desk Lamp",
                "Small lamp",
                "seller1",
                25.0,
                "Furniture",
                true
        );

        // Path 4:
        // listing exists, is ACTIVE, and bid is higher than currentBid
        // expected result = 1 and database is updated

        int result = biddingManager.makeOffer(listingId, "buyer1", 40.0);

        assertEquals(1, result);

        // Verify the listing was really updated in storage
        List<Listing> allListings = biddingManager.getAllListings();
        Listing updated = allListings.stream()
                .filter(listing -> listing.getId() == listingId)
                .findFirst()
                .orElse(null);

        assertNotNull(updated);
        assertEquals(40.0, updated.getCurrentBid(), 0.0001);
        assertEquals("buyer1", updated.getHighestBidder());
    }
}