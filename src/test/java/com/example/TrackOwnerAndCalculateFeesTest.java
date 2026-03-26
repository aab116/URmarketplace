package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TrackOwnerAndCalculateFeesTest {

    @Test
    void constructorRejectsFeeRatesOutsideZeroToOne() {
        // Fee rates below 0 or above 1 are invalid percentages.
        assertThrows(IllegalArgumentException.class, () -> new TrackOwnerAndCalculateFees(-0.01));
        assertThrows(IllegalArgumentException.class, () -> new TrackOwnerAndCalculateFees(1.01));
    }

    @Test
    void recordOriginalOwnerStoresTrimmedValuesOnlyOnce() {
        TrackOwnerAndCalculateFees calculator = new TrackOwnerAndCalculateFees(0.10);

        // The first owner should be saved after trimming spaces.
        calculator.recordOriginalOwner("  item-1  ", "  seller-a  ");

        // Recording the same item again should not replace the original owner.
        calculator.recordOriginalOwner("item-1", "seller-b");

        assertEquals("seller-a", calculator.getOriginalOwner("item-1"));
    }

    @Test
    void recordOriginalOwnerRejectsBlankInputs() {
        TrackOwnerAndCalculateFees calculator = new TrackOwnerAndCalculateFees(0.10);

        // Missing or blank item ids and seller ids should be rejected.
        assertThrows(IllegalArgumentException.class, () -> calculator.recordOriginalOwner(null, "seller"));
        assertThrows(IllegalArgumentException.class, () -> calculator.recordOriginalOwner("   ", "seller"));
        assertThrows(IllegalArgumentException.class, () -> calculator.recordOriginalOwner("item", null));
        assertThrows(IllegalArgumentException.class, () -> calculator.recordOriginalOwner("item", "   "));
    }

    @Test
    void getOriginalOwnerReturnsNullForUnknownOrNullItem() {
        TrackOwnerAndCalculateFees calculator = new TrackOwnerAndCalculateFees(0.10);

        // If an item was never recorded, there should be no original owner.
        assertNull(calculator.getOriginalOwner(null));
        assertNull(calculator.getOriginalOwner("missing"));
    }

    @Test
    void calculateFeesUsesRecordedOriginalOwnerAndReturnsExpectedBreakdown() {
        TrackOwnerAndCalculateFees calculator = new TrackOwnerAndCalculateFees(0.05);
        calculator.recordOriginalOwner("item-100", "seller-original");

        FeeCalculator.FeeResult result = calculator.calculateFees("item-100", "seller-now", 200.0, 15.0);

        // The result should keep the correct item id and original owner.
        assertEquals("item-100", result.itemId);
        assertEquals("seller-original", result.originalOwnerUserId);

        // Check the money breakdown.
        assertEquals(200.0, result.salePrice, 0.0001);
        assertEquals(10.0, result.platformFee, 0.0001);
        assertEquals(15.0, result.storageFee, 0.0001);

        // Net to seller should be sale price minus both fees.
        assertEquals(175.0, result.netToSeller, 0.0001);
    }

    @Test
    void calculateFeesFallsBackToSellerWhenOriginalOwnerMissing() {
        TrackOwnerAndCalculateFees calculator = new TrackOwnerAndCalculateFees(0.10);

        FeeCalculator.FeeResult result = calculator.calculateFees("item-5", "seller-5", 100.0, 5.0);

        // If no original owner was recorded, the current seller becomes the original owner.
        assertEquals("seller-5", result.originalOwnerUserId);
        assertEquals("seller-5", calculator.getOriginalOwner("item-5"));

        // 10 platform fee plus 5 storage fee leaves 85 net.
        assertEquals(85.0, result.netToSeller, 0.0001);
    }

    @Test
    void calculateFeesFloorsNegativeNetPayoutAtZero() {
        TrackOwnerAndCalculateFees calculator = new TrackOwnerAndCalculateFees(0.25);

        FeeCalculator.FeeResult result = calculator.calculateFees("item-9", "seller-9", 10.0, 20.0);

        // 25 percent of 10 is 2.5.
        assertEquals(2.5, result.platformFee, 0.0001);

        // Net payout should not go below zero even if fees are larger than the sale price.
        assertEquals(0.0, result.netToSeller, 0.0001);
    }

    @Test
    void calculateFeesRejectsInvalidInputs() {
        TrackOwnerAndCalculateFees calculator = new TrackOwnerAndCalculateFees(0.05);

        // Bad item ids should fail.
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFees(null, "seller", 100.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFees("   ", "seller", 100.0, 0.0));

        // Bad seller ids should fail.
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFees("item", null, 100.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFees("item", "   ", 100.0, 0.0));

        // Sale price must be a valid positive finite number.
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFees("item", "seller", 0.0, 0.0));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFees("item", "seller", Double.NaN, 0.0));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFees("item", "seller", Double.POSITIVE_INFINITY, 0.0));

        // Storage fee must be valid and not negative.
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFees("item", "seller", 10.0, -0.01));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFees("item", "seller", 10.0, Double.NaN));
    }
}
