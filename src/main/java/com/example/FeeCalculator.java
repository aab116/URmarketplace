package com.example;

/**
 * FeeCalculator
 * -------------
 * Contract for fee calculations.
 *
 * Your report mentions:
 * - Track original owner
 * - Apply holding/storage fees
 * - Calculate net earnings returned to seller
 *
 * IMPORTANT FOR GROUP WORK:
 * - Uses IDs and primitives only.
 * - Returns a FeeResult (a small value object defined inside the interface
 *   so you don't depend on someone else's domain classes).
 */
public interface FeeCalculator {

    /**
     * Calculate the platform + storage fees and return a net earnings result.
     *
     * @param itemId item being sold
     * @param sellerUserId seller user ID
     * @param salePrice final sale price
     * @param storageFee total storage fee (0 if none)
     * @return FeeResult with breakdown
     */
    FeeResult calculateFees(String itemId, String sellerUserId, double salePrice, double storageFee);

    /**
     * Small immutable value object for returning results cleanly.
     */
    class FeeResult {
        public final String itemId;
        public final String originalOwnerUserId;

        public final double salePrice;
        public final double platformFee;
        public final double storageFee;
        public final double netToSeller;

        public FeeResult(String itemId,
                         String originalOwnerUserId,
                         double salePrice,
                         double platformFee,
                         double storageFee,
                         double netToSeller) {
            this.itemId = itemId;
            this.originalOwnerUserId = originalOwnerUserId;
            this.salePrice = salePrice;
            this.platformFee = platformFee;
            this.storageFee = storageFee;
            this.netToSeller = netToSeller;
        }
    }
}