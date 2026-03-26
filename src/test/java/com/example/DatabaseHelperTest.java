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
        // Reset the tables so schema-based tests start from a known state.
        TestDatabaseUtil.resetAllTables();
    }

    @Test
    void connectReturnsOpenConnection() throws Exception {
        try (Connection conn = DatabaseHelper.connect()) {
            // The helper should return a real connection object.
            assertNotNull(conn);

            // The connection should already be open and usable.
            assertFalse(conn.isClosed());
        }
    }

    @Test
    void initializeDatabaseLeavesCoreTablesAvailable() {
        // Run the main database initialization method.
        DatabaseHelper.initializeDatabase();

        // The core app tables should exist afterward.
        assertTrue(TestDatabaseUtil.tableExists("users"));
        assertTrue(TestDatabaseUtil.tableExists("listings"));
        assertTrue(TestDatabaseUtil.tableExists("issues"));
    }

    @Test
    void initializeDatabaseCreatesExpectedUsersColumns() {
        // Initialize the schema, then inspect the users table definition.
        DatabaseHelper.initializeDatabase();

        // These column types are important for login and rating logic.
        assertEquals("TEXT", TestDatabaseUtil.getUserColumnType("password"));
        assertEquals("REAL", TestDatabaseUtil.getUserColumnType("rating_sum"));
        assertEquals("INTEGER", TestDatabaseUtil.getUserColumnType("rating_count"));
    }

    @Test
    void seedMockDataPopulatesUsersListingsAndIssuesWhenUsersTableIsEmpty() {
        // Seed the database from an empty state.
        DatabaseHelper.seedMockData();

        // The seed method should insert its starter data once.
        assertEquals(3, TestDatabaseUtil.countRows("users"));
        assertEquals(5, TestDatabaseUtil.countRows("listings"));
        assertEquals(1, TestDatabaseUtil.countRows("issues"));
    }

    @Test
    void seedMockDataDoesNotDuplicateRowsOnSecondCall() {
        // Seed twice to make sure duplicates are not inserted.
        DatabaseHelper.seedMockData();
        DatabaseHelper.seedMockData();

        // The row counts should stay the same after the second call.
        assertEquals(3, TestDatabaseUtil.countRows("users"));
        assertEquals(5, TestDatabaseUtil.countRows("listings"));
        assertEquals(1, TestDatabaseUtil.countRows("issues"));
    }

    @Test
    void connectCanQueryDatabaseMetadata() throws Exception {
        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table' ORDER BY name")) {

            // If the query returns at least one row, the connection is actually usable.
            assertTrue(rs.next());

            // The returned table name should not be null.
            assertNotNull(rs.getString(1));
        }
    }
}
