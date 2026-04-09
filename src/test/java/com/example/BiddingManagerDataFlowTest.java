package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BiddingManagerDataFlowTest {

    private BiddingManager biddingManager;

    @BeforeEach
    void setUp() {
        TestDatabaseUtil.resetAllTables();
        biddingManager = new BiddingManager();
    }

    @Test
    void duPair_listingIdUsedInSelect_missingListing_returnsMinus1() {
        // listingId is defined as input and used in the SELECT query
        int result = biddingManager.makeOffer(999999, "buyer1", 50.0);

        assertEquals(-1, result);
    }

    @Test
    void duPair_statusDefinedFromDatabase_usedInActiveCheck_returnsMinus2() {
        int listingId = biddingManager.createListing(
                "Desk Lamp",
                "Small lamp",
                "seller1",
                25.0,
                "Furniture",
                true
        );

        // status is defined from the database row and then used in the ACTIVE check
        TestDatabaseUtil.execute("UPDATE listings SET status = 'SOLD' WHERE id = " + listingId);

        int result = biddingManager.makeOffer(listingId, "buyer1", 40.0);

        assertEquals(-2, result);
    }

    @Test
    void duPair_currentBidDefinedFromDatabase_usedInComparison_returnsMinus3() {
        int listingId = biddingManager.createListing(
                "Desk Lamp",
                "Small lamp",
                "seller1",
                25.0,
                "Furniture",
                true
        );

        // currentBid is defined from the database row and then used in the amount comparison
        int result = biddingManager.makeOffer(listingId, "buyer1", 25.0);

        assertEquals(-3, result);
    }

    @Test
    void duPair_amountAndBidderUsername_usedInUpdate_persistCorrectValues() {
        int listingId = biddingManager.createListing(
                "Desk Lamp",
                "Small lamp",
                "seller1",
                25.0,
                "Furniture",
                true
        );

        // amount and bidderUsername are defined as inputs and then used in the UPDATE statement
        int result = biddingManager.makeOffer(listingId, "buyer1", 40.0);

        assertEquals(1, result);

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