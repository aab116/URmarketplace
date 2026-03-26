package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void constructorSetsFieldsAndStartsLoggedOut() {
        // Create a user with the main constructor.
        User user = new User("amr", "amr@example.com", "secret");

        // The constructor should copy the provided values.
        assertEquals("amr", user.getUsername());
        assertEquals("amr@example.com", user.getEmail());
        assertEquals("secret", user.getPassword());

        // New users should start logged out.
        assertFalse(user.isLoggedIn());

        // With no ratings yet, the average should be zero.
        assertEquals(0.0, user.getAverageRating(), 0.0001);
    }

    @Test
    void settersAndGettersRoundTripValues() {
        // Start with the empty constructor and set fields manually.
        User user = new User();

        user.setId(7);
        user.setUsername("user7");
        user.setEmail("u7@test.com");
        user.setPassword("pw");
        user.setLoggedIn(true);

        // Every getter should return the same value that was set.
        assertEquals(7, user.getId());
        assertEquals("user7", user.getUsername());
        assertEquals("u7@test.com", user.getEmail());
        assertEquals("pw", user.getPassword());
        assertTrue(user.isLoggedIn());
    }

    @Test
    void averageRatingIsZeroBeforeAnyRatings() {
        // A new user with no ratings should average to zero.
        User user = new User();

        assertEquals(0.0, user.getAverageRating(), 0.0001);
    }

    @Test
    void addRatingUpdatesAverageAcrossMultipleValues() {
        // Add three ratings and check that the average is calculated correctly.
        User user = new User();

        user.addRating(5.0);
        user.addRating(3.0);
        user.addRating(4.0);

        assertEquals(4.0, user.getAverageRating(), 0.0001);
    }
}
