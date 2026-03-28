package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * BiddingManagerDecisionTableTest
 * Purpose:
 * Adds explicit decision-table coverage for the marketplace bidding logic.
 */
class BiddingManagerDecisionTableTest {

    private BiddingManager biddingManager;

    @BeforeEach
    void setUp() {
        // Rebuild all core tables before every test so each rule runs in isolation.
        TestDatabaseUtil.resetAllTables();

        // Create a fresh manager object for each test.
        biddingManager = new BiddingManager();
    }

    @Test
    void makeOfferDecisionTableCoversMissingInactiveLowEqualAndValidCases() {
        // Rule 1: Listing does not exist
        // Expected result: -1
        assertEquals(-1, biddingManager.makeOffer(999999, "ghostBuyer", 50.0));

        // Create one real ACTIVE listing to use for the remaining rules.
        int listingId = biddingManager.createListing(
                "Desk Lamp",
                "Small desk lamp",
                "seller1",
                25.0,
                "Furniture",
                true);

        // Rule 2: Listing exists but is not ACTIVE
        // Expected result: -2
        TestDatabaseUtil.execute("UPDATE listings SET status = 'SOLD' WHERE id = " + listingId);
        assertEquals(-2, biddingManager.makeOffer(listingId, "buyer1", 30.0));

        // Put the listing back into ACTIVE for the next rules.
        TestDatabaseUtil.execute("UPDATE listings SET status = 'ACTIVE' WHERE id = " + listingId);

        // Rule 3: Listing is ACTIVE but bid is lower than currentBid
        // Expected result: -3

        assertEquals(-3, biddingManager.makeOffer(listingId, "buyer1", 20.0));


        // Rule 4: Listing is ACTIVE but bid is equal to currentBid
        // Expected result: -3

        assertEquals(-3, biddingManager.makeOffer(listingId, "buyer1", 25.0));

        // Rule 5: Listing is ACTIVE and bid is greater than currentBid
        // Expected result: success (1)

        assertEquals(1, biddingManager.makeOffer(listingId, "buyer1", 40.0));

        // Verify the database-backed listing was actually updated.
        List<Listing> allListings = biddingManager.getAllListings();
        Listing updated = allListings.stream()
                .filter(listing -> listing.getId() == listingId)
                .findFirst()
                .orElse(null);

        assertNotNull(updated);
        assertEquals(40.0, updated.getCurrentBid(), 0.0001);
        assertEquals("buyer1", updated.getHighestBidder());
    }

    @Test
    void buyNowDecisionTableCoversMissingInactiveNoPriceAndValidCases() {
        // Rule 1: Listing does not exist
        // Expected result: false
        assertFalse(biddingManager.buyNow(999999, "buyerX"));

        // Create a listing with no buy-now price.
        int noBuyNowId = biddingManager.createListing(
                "Office Chair",
                "Used chair",
                "seller2",
                60.0,
                "Furniture",
                false);

        // Rule 2: Listing is ACTIVE but buyNowPrice <= 0
        // Expected result: false

        assertFalse(biddingManager.buyNow(noBuyNowId, "buyerX"));

        // Create a proper buy-now listing.
        int buyNowListingId = biddingManager.createListingWithBuyNow(
                "Mini Fridge",
                "Works well",
                "seller3",
                80.0,
                120.0,
                "Appliances",
                false);

        // Rule 3: Listing exists, has buyNowPrice, but is not ACTIVE
        // Expected result: false

        TestDatabaseUtil.execute("UPDATE listings SET status = 'CANCELLED' WHERE id = " + buyNowListingId);
        assertFalse(biddingManager.buyNow(buyNowListingId, "buyerY"));

        // Put it back into ACTIVE for the valid rule.
        TestDatabaseUtil.execute("UPDATE listings SET status = 'ACTIVE' WHERE id = " + buyNowListingId);

        // Rule 4: Listing exists, ACTIVE, and buyNowPrice > 0
        // Expected result: true

        assertTrue(biddingManager.buyNow(buyNowListingId, "buyerY"));

        // Confirm the state transition and winner information after purchase.
        assertEquals("SOLD",
                TestDatabaseUtil.queryString("SELECT status FROM listings WHERE id = " + buyNowListingId));
        assertEquals("buyerY",
                TestDatabaseUtil.queryString("SELECT highestBidder FROM listings WHERE id = " + buyNowListingId));
        assertEquals(120.0,
                TestDatabaseUtil.queryDouble("SELECT currentBid FROM listings WHERE id = " + buyNowListingId),
                0.0001);
    }
}