package com.example;


import java.util.HashMap;
import java.util.Map;

/**
 * TrackOwnerAndCalculateFees
 * --------------------------
 * Implements FeeCalculator.
 *
 * Responsibilities:
 * 1) Track ORIGINAL owner of an item (first seller who listed it)
 * 2) Calculate platform fee + storage fee
 * 3) Compute net earnings returned to seller
 *
 * IMPORTANT FOR GROUP WORK:
 * - Does not require Item/User objects.
 * - Teammates just pass IDs and numbers.
 */
public class TrackOwnerAndCalculateFees implements FeeCalculator {

    // Map itemId -> originalOwnerUserId
    private final Map<String, String> originalOwnerByItemId = new HashMap<>();

    // Example fee rule: platform fee is a percentage of sale price (e.g., 0.05 = 5%)
    private final double platformFeeRate;

    public TrackOwnerAndCalculateFees(double platformFeeRate) {
        if (platformFeeRate < 0 || platformFeeRate > 1) {
            throw new IllegalArgumentException("platformFeeRate must be between 0 and 1.");
        }
        this.platformFeeRate = platformFeeRate;
    }

    /**
     * Call this when an item is first posted.
     * If called again, it will NOT overwrite the original owner.
     */
    public void recordOriginalOwner(String itemId, String ownerUserId) {
        if (itemId == null || itemId.trim().isEmpty()) {
            throw new IllegalArgumentException("itemId cannot be blank.");
        }
        if (ownerUserId == null || ownerUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("ownerUserId cannot be blank.");
        }

        // Only set once (original means first)
        originalOwnerByItemId.putIfAbsent(itemId.trim(), ownerUserId.trim());
    }

    /**
     * Retrieve original owner if known.
     */
    public String getOriginalOwner(String itemId) {
        if (itemId == null) return null;
        return originalOwnerByItemId.get(itemId.trim());
    }

    @Override
    public FeeResult calculateFees(String itemId, String sellerUserId, double salePrice, double storageFee) {
        // Validate IDs
        if (itemId == null || itemId.trim().isEmpty()) {
            throw new IllegalArgumentException("itemId cannot be blank.");
        }
        if (sellerUserId == null || sellerUserId.trim().isEmpty()) {
            throw new IllegalArgumentException("sellerUserId cannot be blank.");
        }

        // Validate numbers
        if (Double.isNaN(salePrice) || Double.isInfinite(salePrice) || salePrice <= 0) {
            throw new IllegalArgumentException("salePrice must be a valid number > 0.");
        }
        if (Double.isNaN(storageFee) || Double.isInfinite(storageFee) || storageFee < 0) {
            throw new IllegalArgumentException("storageFee cannot be negative.");
        }

        // Ensure original owner exists (optional, but helpful)
        // If not recorded, we can treat current seller as original owner or leave null.
        String originalOwner = originalOwnerByItemId.get(itemId.trim());
        if (originalOwner == null) {
            // Safe fallback: assume the first time we calculate fees, seller is the original owner.
            // If your group doesn't want this behavior, replace with "null" instead.
            originalOwner = sellerUserId.trim();
            originalOwnerByItemId.put(itemId.trim(), originalOwner);
        }

        // Platform fee
        double platformFee = salePrice * platformFeeRate;

        // Net returned to seller
        double net = salePrice - platformFee - storageFee;

        // Prevent negative payout (optional business rule)
        if (net < 0) net = 0;

        return new FeeResult(
                itemId.trim(),
                originalOwner,
                salePrice,
                platformFee,
                storageFee,
                net
        );
    }
}