package com.example;

import java.util.Objects;

/**
 * ModifyItem
 * ----------
 * Concrete utility/service class for validating and applying modifications
 * to an item's fields.
 *
 * IMPORTANT FOR GROUP WORK:
 * - This class does NOT define the Item class.
 * - It operates on raw values (Strings/doubles) and returns cleaned values.
 * - Your teammate can call these methods and then set the values on their Item object.
 */
public class ModifyItem {

    // Constraints based on your report (and reasonable defaults)
    public static final int MAX_TITLE_LENGTH = 100;
    public static final int MAX_DESCRIPTION_LENGTH = 500;

    /**
     * Validates and cleans a title for an item listing.
     * @param newTitle raw user input title
     * @return cleaned title (trimmed)
     */
    public String validateAndCleanTitle(String newTitle) {
        if (newTitle == null) {
            throw new IllegalArgumentException("Title cannot be null.");
        }

        String cleaned = newTitle.trim();

        if (cleaned.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }

        if (cleaned.length() > MAX_TITLE_LENGTH) {
            throw new IllegalArgumentException("Title too long. Max " + MAX_TITLE_LENGTH + " characters.");
        }

        return cleaned;
    }

    /**
     * Validates and cleans a description.
     * @param newDescription raw user input description
     * @return description (as-is, but validated)
     */
    public String validateDescription(String newDescription) {
        if (newDescription == null) {
            throw new IllegalArgumentException("Description cannot be null.");
        }

        if (newDescription.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException("Description too long. Max " + MAX_DESCRIPTION_LENGTH + " characters.");
        }

        return newDescription;
    }

    /**
     * Validates a fixed sale price (or buy-now price).
     */
    public double validatePrice(double newPrice) {
        if (Double.isNaN(newPrice) || Double.isInfinite(newPrice)) {
            throw new IllegalArgumentException("Price must be a valid number.");
        }

        if (newPrice <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }

        return newPrice;
    }

    /**
     * Validates a bidding price (starting bid or current bid).
     * Some systems allow 0, but you can enforce >0 if needed.
     */
    public double validateBiddingPrice(double biddingPrice) {
        if (Double.isNaN(biddingPrice) || Double.isInfinite(biddingPrice)) {
            throw new IllegalArgumentException("Bidding price must be a valid number.");
        }

        if (biddingPrice < 0) {
            throw new IllegalArgumentException("Bidding price cannot be negative.");
        }

        return biddingPrice;
    }

    /**
     * Helper validation for IDs used elsewhere in your system.
     */
    public String requireNonBlankId(String id, String label) {
        Objects.requireNonNull(label, "label");
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException(label + " cannot be blank.");
        }
        return id.trim();
    }
}