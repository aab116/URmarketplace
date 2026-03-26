package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

final class TestDatabaseUtil {

    private TestDatabaseUtil() {}

    static void resetAllTables() {
        try (Connection conn = DatabaseHelper.connect(); Statement stmt = conn.createStatement()) {
            // Drop the tables first so every test starts from a clean database state.
            stmt.execute("DROP TABLE IF EXISTS users");
            stmt.execute("DROP TABLE IF EXISTS listings");
            stmt.execute("DROP TABLE IF EXISTS issues");

            // Recreate the users table with the columns the app expects.
            stmt.execute("CREATE TABLE users ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "username TEXT UNIQUE, "
                    + "email TEXT, "
                    + "password TEXT, "
                    + "rating_sum REAL DEFAULT 0, "
                    + "rating_count INTEGER DEFAULT 0"
                    + ")");

            // Recreate the listings table so bidding tests can save and read listings.
            stmt.execute("CREATE TABLE listings ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "title TEXT, "
                    + "description TEXT, "
                    + "sellerUsername TEXT, "
                    + "originalOwnerUsername TEXT, "
                    + "startingPrice REAL, "
                    + "currentBid REAL, "
                    + "buyNowPrice REAL, "
                    + "highestBidder TEXT, "
                    + "category TEXT, "
                    + "status TEXT, "
                    + "isAuction BOOLEAN"
                    + ")");

            // Recreate the issues table for issue-reporting tests.
            stmt.execute("CREATE TABLE issues ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "title TEXT, "
                    + "description TEXT, "
                    + "category TEXT, "
                    + "reportedBy TEXT, "
                    + "studentId INTEGER, "
                    + "status TEXT"
                    + ")");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to reset database tables", e);
        }
    }

    static void clearTable(String tableName) {
        try (Connection conn = DatabaseHelper.connect(); Statement stmt = conn.createStatement()) {
            // Remove all rows but keep the table itself.
            stmt.execute("DELETE FROM " + tableName);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to clear table: " + tableName, e);
        }
    }

    static int countRows(String tableName) {
        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM " + tableName)) {
            // Move to the first row so we can read the count result.
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to count rows in: " + tableName, e);
        }
    }

    static String getUserColumnType(String columnName) {
        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("PRAGMA table_info(users)")) {
            // Scan the users table schema until we find the requested column.
            while (rs.next()) {
                if (columnName.equalsIgnoreCase(rs.getString("name"))) {
                    return rs.getString("type");
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to read users schema", e);
        }
    }

    static boolean tableExists(String tableName) {
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT COUNT(*) FROM sqlite_master WHERE type='table' AND name = ?")) {
            // Use sqlite_master because that is where SQLite stores table metadata.
            pstmt.setString(1, tableName);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1) == 1;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to inspect sqlite_master", e);
        }
    }

    static String queryString(String sql) {
        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // Run a query that should return one text value.
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException("Failed string query", e);
        }
    }

    static int queryInt(String sql) {
        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // Run a query that should return one integer value.
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException("Failed int query", e);
        }
    }

    static double queryDouble(String sql) {
        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            // Run a query that should return one decimal value.
            rs.next();
            return rs.getDouble(1);
        } catch (SQLException e) {
            throw new RuntimeException("Failed double query", e);
        }
    }

    static void execute(String sql) {
        try (Connection conn = DatabaseHelper.connect(); Statement stmt = conn.createStatement()) {
            // Use this for direct SQL updates inside tests.
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Failed SQL execution", e);
        }
    }
}
