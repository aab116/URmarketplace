package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserManagerTest {

    private UserManager userManager;

    @BeforeEach
    void setUp() {
        // Reset the users table before every test.
        TestDatabaseUtil.resetAllTables();
        userManager = new UserManager();
    }

    @Test
    void registerPersistsNewUser() {
        // Register a brand new user.
        boolean result = userManager.register("alice", "alice@test.com", "pw123");

        // The registration should succeed.
        assertTrue(result);

        // One user row should be saved in the database.
        assertEquals(1, TestDatabaseUtil.countRows("users"));

        // The saved email should match what was passed in.
        assertEquals("alice@test.com", TestDatabaseUtil.queryString("SELECT email FROM users WHERE username = 'alice'"));
    }

    @Test
    void registerReturnsFalseForDuplicateUsername() {
        // First registration should work.
        assertTrue(userManager.register("alice", "alice@test.com", "pw123"));

        // Registering the same username again should fail.
        assertFalse(userManager.register("alice", "second@test.com", "newpw"));

        // The table should still contain only the first user.
        assertEquals(1, TestDatabaseUtil.countRows("users"));
    }

    @Test
    void loginReturnsLoggedInUserForCorrectCredentials() {
        // Save a user, then log in with the correct password.
        userManager.register("alice", "alice@test.com", "pw123");
        User user = userManager.login("alice", "pw123");

        // A valid login should return a real User object.
        assertNotNull(user);
        assertEquals("alice", user.getUsername());
        assertEquals("alice@test.com", user.getEmail());
        assertEquals("pw123", user.getPassword());

        // The returned user should be marked as logged in.
        assertTrue(user.isLoggedIn());

        // The database should also have assigned a real id.
        assertTrue(user.getId() > 0);
    }

    @Test
    void loginReturnsNullForWrongCredentials() {
        // Register one valid user.
        userManager.register("alice", "alice@test.com", "pw123");

        // Wrong password and missing username should both return null.
        assertNull(userManager.login("alice", "wrong"));
        assertNull(userManager.login("missing", "pw123"));
    }

    @Test
    void rateUserUpdatesRatingColumnsForExistingUser() {
        // Create a user, then apply two ratings.
        userManager.register("alice", "alice@test.com", "pw123");
        userManager.rateUser("alice", 4.5);
        userManager.rateUser("alice", 3.5);

        // The raw rating sum and count in the database should update correctly.
        assertEquals(8.0, TestDatabaseUtil.queryDouble("SELECT rating_sum FROM users WHERE username = 'alice'"), 0.0001);
        assertEquals(2, TestDatabaseUtil.queryInt("SELECT rating_count FROM users WHERE username = 'alice'"));
    }

    @Test
    void rateUserDoesNothingForUnknownUser() {
        // Rating a user who does not exist should not create any rows.
        userManager.rateUser("missing", 4.0);

        assertEquals(0, TestDatabaseUtil.countRows("users"));
    }
}
