package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseHelperTest {

    @BeforeEach
    void setUp() {
        // Delete the actual SQLite file so each test simulates a fresh first run
        TestDatabaseUtil.deleteDatabaseFile();
    }

    @Test
    void connectReturnsOpenConnection() throws Exception {
        try (Connection conn = DatabaseHelper.connect()) {
            // The helper should return a real connection object
            assertNotNull(conn);

            // The connection should already be open and usable
            assertFalse(conn.isClosed());
        }
    }

    @Test
    void initializeDatabaseLeavesCoreTablesAvailable() {
        // Run the real startup initialization on a fresh database file
        DatabaseHelper.initializeDatabase();

        // The core app tables should exist afterward
        assertTrue(TestDatabaseUtil.tableExists("users"));
        assertTrue(TestDatabaseUtil.tableExists("listings"));
        assertTrue(TestDatabaseUtil.tableExists("issues"));
    }

    @Test
    void initializeDatabaseCreatesExpectedUsersColumns() {
        // Build the schema from scratch
        DatabaseHelper.initializeDatabase();

        // These columns must exist as separate columns in the users table
        assertEquals("TEXT", TestDatabaseUtil.getUserColumnType("password"));
        assertEquals("REAL", TestDatabaseUtil.getUserColumnType("rating_sum"));
        assertEquals("INTEGER", TestDatabaseUtil.getUserColumnType("rating_count"));
    }

    @Test
    void seedMockDataPopulatesUsersListingsAndIssuesWhenUsersTableIsEmpty() {
        // Initialize schema first, then seed it
        DatabaseHelper.initializeDatabase();
        DatabaseHelper.seedMockData();

        // The seed method should insert its starter data once
        assertEquals(3, TestDatabaseUtil.countRows("users"));
        assertEquals(5, TestDatabaseUtil.countRows("listings"));
        assertEquals(1, TestDatabaseUtil.countRows("issues"));
    }

    @Test
    void seedMockDataDoesNotDuplicateRowsOnSecondCall() {
        // Initialize schema and seed twice
        DatabaseHelper.initializeDatabase();
        DatabaseHelper.seedMockData();
        DatabaseHelper.seedMockData();

        // The row counts should stay the same after the second call
        assertEquals(3, TestDatabaseUtil.countRows("users"));
        assertEquals(5, TestDatabaseUtil.countRows("listings"));
        assertEquals(1, TestDatabaseUtil.countRows("issues"));
    }

    @Test
    void connectCanRunSimpleQuery() throws Exception {
        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1")) {

            // If this works, the connection is usable even before schema creation
            assertTrue(rs.next());
            assertEquals(1, rs.getInt(1));
        }
    }
}