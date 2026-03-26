package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModifyItemTest {

    private ModifyItem modifyItem;

    @BeforeEach
    void setUp() {
        // Make a fresh validator object before every test.
        modifyItem = new ModifyItem();
    }

    @Test
    void validateAndCleanTitleTrimsWhitespace() {
        // Titles with extra spaces should be cleaned before returning.
        assertEquals("Gaming Laptop", modifyItem.validateAndCleanTitle("   Gaming Laptop   "));
    }

    @Test
    void validateAndCleanTitleRejectsNullEmptyAndTooLong() {
        // Build a title that is one character over the max length.
        String tooLong = "x".repeat(ModifyItem.MAX_TITLE_LENGTH + 1);

        // Null, blank, and oversized titles should all be rejected.
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validateAndCleanTitle(null));
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validateAndCleanTitle("   "));
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validateAndCleanTitle(tooLong));
    }

    @Test
    void validateDescriptionAcceptsValidTextIncludingEmptyString() {
        // Normal descriptions should pass through unchanged.
        assertEquals("Simple description", modifyItem.validateDescription("Simple description"));

        // This method also allows an empty string.
        assertEquals("", modifyItem.validateDescription(""));
    }

    @Test
    void validateDescriptionRejectsNullAndTooLong() {
        // Build a description that is too long.
        String tooLong = "d".repeat(ModifyItem.MAX_DESCRIPTION_LENGTH + 1);

        // Null and oversized descriptions should fail validation.
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validateDescription(null));
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validateDescription(tooLong));
    }

    @Test
    void validatePriceAcceptsPositiveValueOnly() {
        // A normal positive price should be accepted.
        assertEquals(99.99, modifyItem.validatePrice(99.99), 0.0001);

        // Zero, negative, NaN, and infinity should all be rejected.
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validatePrice(0));
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validatePrice(-1));
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validatePrice(Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validatePrice(Double.POSITIVE_INFINITY));
    }

    @Test
    void validateBiddingPriceAllowsZeroButRejectsNegativeAndInvalidNumbers() {
        // This validator allows zero because an item may start without a bid.
        assertEquals(0.0, modifyItem.validateBiddingPrice(0.0), 0.0001);
        assertEquals(25.0, modifyItem.validateBiddingPrice(25.0), 0.0001);

        // Negative or invalid numbers should still fail.
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validateBiddingPrice(-0.01));
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validateBiddingPrice(Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> modifyItem.validateBiddingPrice(Double.NEGATIVE_INFINITY));
    }

    @Test
    void requireNonBlankIdTrimsValidIdsAndRejectsBadInput() {
        // Valid ids should be trimmed and returned.
        assertEquals("abc-123", modifyItem.requireNonBlankId("  abc-123  ", "itemId"));

        // Null and blank ids should be rejected.
        assertThrows(IllegalArgumentException.class, () -> modifyItem.requireNonBlankId(null, "itemId"));
        assertThrows(IllegalArgumentException.class, () -> modifyItem.requireNonBlankId("   ", "itemId"));

        // A null field name usually triggers a NullPointerException in the validation code.
        assertThrows(NullPointerException.class, () -> modifyItem.requireNonBlankId("abc", null));
    }
}
