package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BiddingManager {

    // --- 1. POSTING ITEMS ---
    public int createListing(String title, String description, String sellerUsername,
            double price, String category, boolean isAuction) {
        return createListingWithBuyNow(title, description, sellerUsername, price, 0.0, category, isAuction);
    }

    public int createListingWithBuyNow(String title, String description, String sellerUsername,
            double startingPrice, double buyNowPrice,
            String category, boolean isAuction) {

        String sql = "INSERT INTO listings (title, description, sellerUsername, originalOwnerUsername, "
                + "startingPrice, currentBid, buyNowPrice, category, status, isAuction) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'ACTIVE', ?)";

        try (Connection conn = DatabaseHelper.connect(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setString(3, sellerUsername);
            pstmt.setString(4, sellerUsername); // Tracks original owner for fee calculator
            pstmt.setDouble(5, startingPrice);
            pstmt.setDouble(6, startingPrice);
            pstmt.setDouble(7, buyNowPrice);
            pstmt.setString(8, category);
            pstmt.setBoolean(9, isAuction);

            pstmt.executeUpdate();

            // Retrieve the auto-generated ID from SQLite
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error creating listing: " + e.getMessage());
        }
        return -1;
    }

    // --- 2. BIDDING ---
    public int makeOffer(int listingId, String bidderUsername, double amount) {
        String checkSql = "SELECT status, currentBid FROM listings WHERE id = ?";

        try (Connection conn = DatabaseHelper.connect(); PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setInt(1, listingId);
            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next()) {
                return -1; // Item does not exist
            }
            if (!"ACTIVE".equals(rs.getString("status"))) {
                return -2; // Not active
            }
            if (amount <= rs.getDouble("currentBid")) {
                return -3; // Bid too low
            }
            // If checks pass, update the database with the new highest bid
            String updateSql = "UPDATE listings SET currentBid = ?, highestBidder = ? WHERE id = ?";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                updateStmt.setDouble(1, amount);
                updateStmt.setString(2, bidderUsername);
                updateStmt.setInt(3, listingId);
                updateStmt.executeUpdate();
                return 1; // Success!
            }

        } catch (SQLException e) {
            System.out.println("Error making offer: " + e.getMessage());
        }
        return -4;
    }

    // --- 3. BUY NOW ---
    public boolean buyNow(int listingId, String buyerUsername) {
        String checkSql = "SELECT status, buyNowPrice FROM listings WHERE id = ?";

        try (Connection conn = DatabaseHelper.connect(); PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setInt(1, listingId);
            ResultSet rs = checkStmt.executeQuery();

            if (!rs.next()) {
                return false;
            }

            double buyNowPrice = rs.getDouble("buyNowPrice");
            if (!"ACTIVE".equals(rs.getString("status")) || buyNowPrice <= 0) {
                return false;
            }

            // Update the item to SOLD and record the winner
            String updateSql = "UPDATE listings SET status = 'SOLD', highestBidder = ?, currentBid = ? WHERE id = ?";
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                updateStmt.setString(1, buyerUsername);
                updateStmt.setDouble(2, buyNowPrice);
                updateStmt.setInt(3, listingId);
                updateStmt.executeUpdate();
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error on buy now: " + e.getMessage());
        }
        return false;
    }

    // --- 4. RETRIEVING ITEMS ---
    public List<Listing> getAllListings() {
        List<Listing> listings = new ArrayList<>();
        String sql = "SELECT * FROM listings";

        try (Connection conn = DatabaseHelper.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                listings.add(mapRowToListing(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching listings: " + e.getMessage());
        }
        return listings;
    }

    public List<Listing> searchByCategory(String category) {
        List<Listing> result = new ArrayList<>();
        String sql = "SELECT * FROM listings WHERE category = ? AND status = 'ACTIVE'";

        try (Connection conn = DatabaseHelper.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, category);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result.add(mapRowToListing(rs));
            }
        } catch (SQLException e) {
            System.out.println("Error searching by category: " + e.getMessage());
        }
        return result;
    }

    // Helper method to convert SQL rows into Java Listing objects
    private Listing mapRowToListing(ResultSet rs) throws SQLException {
        Listing listing = new Listing();
        listing.setId(rs.getInt("id"));
        listing.setTitle(rs.getString("title"));
        listing.setDescription(rs.getString("description"));
        listing.setSellerUsername(rs.getString("sellerUsername"));
        listing.setStartingPrice(rs.getDouble("startingPrice"));
        listing.setCurrentBid(rs.getDouble("currentBid"));
        listing.setBuyNowPrice(rs.getDouble("buyNowPrice"));
        listing.setHighestBidder(rs.getString("highestBidder"));
        listing.setCategory(rs.getString("category"));
        listing.setStatus(rs.getString("status"));
        listing.setAuction(rs.getBoolean("isAuction"));
        return listing;
    }
}
