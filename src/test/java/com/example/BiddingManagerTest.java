package com.example;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BiddingManagerTest {

    private BiddingManager manager;

    @BeforeEach
    public void setUp() {
        // 1. Ensure the database and tables actually exist for the test
        DatabaseHelper.initializeDatabase();

        // 2. Clear out the listings table so every test starts completely fresh
        // This is called "Test Isolation"
        try (Connection conn = DatabaseHelper.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM listings");
        } catch (Exception e) {
            System.out.println("Could not clear database: " + e.getMessage());
        }

        manager = new BiddingManager();
    }

    @Test
    public void testSearchByCategory() {
        // Requirement: "Search database for item -> Category"
        manager.createListing("Smartphone", "Brand new", "seller1", 500.0, "Electronics", true);
        manager.createListing("Java Book", "Used", "seller2", 20.0, "Books", false);

        List<Listing> results = manager.searchByCategory("Electronics");

        assertEquals(1, results.size(), "Should find exactly one item in Electronics");
        assertEquals("Smartphone", results.get(0).getTitle());
    }

    @Test
    public void testMakeValidBid() {
        // Requirement: "BIDDING / make an offer"
        int listingId = manager.createListing("Vintage Camera", "Rare", "userA", 100.0, "Photography", true);

        // A valid bid must be higher than the current bid (starting price)
        int offerId = manager.makeOffer(listingId, "userB", 150.0);

        assertTrue(offerId > 0, "Offer should be accepted and return a valid ID");

        // We find the specific listing we just made by using a loop, to ensure we check the right one
        Listing updatedListing = null;
        for (Listing l : manager.getAllListings()) {
            if (l.getId() == listingId) {
                updatedListing = l;
                break;
            }
        }

        assertNotNull(updatedListing);
        assertEquals(150.0, updatedListing.getCurrentBid());
    }

    @Test
    public void testMakeInvalidBid() {
        int listingId = manager.createListing("Laptop", "Gaming", "userA", 1000.0, "Tech", true);

        // Attempting to bid lower than the starting price should return -3
        int result = manager.makeOffer(listingId, "userB", 500.0);

        assertEquals(-3, result, "Should return -3 because the bid is too low");
    }
}
