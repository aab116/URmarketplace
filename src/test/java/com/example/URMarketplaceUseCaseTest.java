package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * URMarketplaceUseCaseTest
 *
 * Purpose:
 * Adds realistic end-to-end workflow tests so you can honestly claim
 * use-case testing in the report.
 */
class URMarketplaceUseCaseTest {

        private UserManager userManager;
        private BiddingManager biddingManager;
        private IssueManager issueManager;
        private TrackOwnerAndCalculateFees feeCalculator;

        @BeforeEach
        void setUp() {
                // Reset the full database before each use case so the workflows
                // do not interfere with one another.
                TestDatabaseUtil.resetAllTables();

                userManager = new UserManager();
                biddingManager = new BiddingManager();
                issueManager = new IssueManager();
                feeCalculator = new TrackOwnerAndCalculateFees(0.10); // 10% platform fee
        }

        @Test
        void useCaseBuyerPurchasesItemAndSellerFeesAreCalculated() {
                // USE CASE:
                // 1. Seller registers
                // 2. Buyer registers
                // 3. Both log in
                // 4. Seller posts an item
                // 5. Buyer finds the item by category
                // 6. Buyer purchases with buy now
                // 7. System transitions item to SOLD
                // 8. Seller payout is calculated

                // Step 1: Register seller and buyer.
                assertTrue(userManager.register("sellerA", "sellerA@test.com", "pw1"));
                assertTrue(userManager.register("buyerA", "buyerA@test.com", "pw2"));

                // Step 2: Log both users in.
                User seller = userManager.login("sellerA", "pw1");
                User buyer = userManager.login("buyerA", "pw2");

                assertNotNull(seller);
                assertNotNull(buyer);
                assertTrue(seller.isLoggedIn());
                assertTrue(buyer.isLoggedIn());

                // Step 3: Seller creates a listing with a buy-now option.
                int listingId = biddingManager.createListingWithBuyNow(
                                "Microwave",
                                "Compact microwave in good condition",
                                seller.getUsername(),
                                50.0,
                                75.0,
                                "Appliances",
                                false);

                assertTrue(listingId > 0);

                // Step 4: Record the original owner for later fee calculation.
                feeCalculator.recordOriginalOwner(String.valueOf(listingId), seller.getUsername());

                // Step 5: Buyer searches for the item by category.
                List<Listing> activeApplianceListings = biddingManager.searchByCategory("Appliances");

                assertEquals(1, activeApplianceListings.size());
                assertEquals("Microwave", activeApplianceListings.get(0).getTitle());
                assertEquals("ACTIVE", activeApplianceListings.get(0).getStatus());

                // Step 6: Buyer purchases the item with buy now.
                assertTrue(biddingManager.buyNow(listingId, buyer.getUsername()));

                // Step 7: Verify state transition to SOLD and confirm that the item
                // no longer appears in ACTIVE category search results.
                assertEquals("SOLD",
                                TestDatabaseUtil.queryString("SELECT status FROM listings WHERE id = " + listingId));
                assertEquals("buyerA",
                                TestDatabaseUtil.queryString(
                                                "SELECT highestBidder FROM listings WHERE id = " + listingId));

                List<Listing> resultsAfterPurchase = biddingManager.searchByCategory("Appliances");
                assertFalse(resultsAfterPurchase.stream().anyMatch(listing -> listing.getId() == listingId));

                // Step 8: Calculate seller payout after platform fee and storage fee.
                FeeCalculator.FeeResult result = feeCalculator.calculateFees(
                                String.valueOf(listingId),
                                seller.getUsername(),
                                75.0,
                                5.0);

                assertEquals(String.valueOf(listingId), result.itemId);
                assertEquals("sellerA", result.originalOwnerUserId);
                assertEquals(7.5, result.platformFee, 0.0001);
                assertEquals(5.0, result.storageFee, 0.0001);
                assertEquals(62.5, result.netToSeller, 0.0001);
        }

        @Test
        void useCaseUserReportsIssueAndAdminCanRetrieveIt() {
                // USE CASE:
                // 1. User registers
                // 2. User logs in
                // 3. User reports an issue
                // 4. System stores issue
                // 5. Admin/system retrieves issue list

                // Step 1: Register the user.
                assertTrue(userManager.register("reporter1", "reporter1@test.com", "pw3"));

                // Step 2: Log in.
                User reporter = userManager.login("reporter1", "pw3");
                assertNotNull(reporter);
                assertTrue(reporter.isLoggedIn());

                // Step 3: Submit an issue report.
                int issueId = issueManager.reportIssue(
                                "Listing Problem",
                                "Unable to edit my posted item",
                                "Technical",
                                reporter.getUsername(),
                                200500001);

                assertTrue(issueId > 0);

                // Step 4 + 5: Retrieve the saved issue and verify the stored data.
                List<Issue> issues = issueManager.getAllIssues();
                assertEquals(1, issues.size());

                Issue savedIssue = issues.get(0);
                assertEquals(issueId, savedIssue.getId());
                assertEquals("Listing Problem", savedIssue.getTitle());
                assertEquals("Unable to edit my posted item", savedIssue.getDescription());
                assertEquals("Technical", savedIssue.getCategory());
                assertEquals("reporter1", savedIssue.getReportedBy());
                assertEquals(200500001, savedIssue.getStudentId());
                assertEquals("OPEN", savedIssue.getStatus());
        }

        @Test
        void useCaseStorageFeeFlowsIntoFinalPayoutCalculation() {
                ArrangeStorage storage = new ArrangeStorageImpl();
                TrackOwnerAndCalculateFees calculator = new TrackOwnerAndCalculateFees(0.10);

                assertTrue(userManager.register("sellerB", "sellerB@test.com", "pw1"));
                assertTrue(userManager.register("buyerB", "buyerB@test.com", "pw2"));

                User seller = userManager.login("sellerB", "pw1");
                User buyer = userManager.login("buyerB", "pw2");

                assertNotNull(seller);
                assertNotNull(buyer);

                int listingId = biddingManager.createListingWithBuyNow(
                                "Mini Fridge",
                                "Works well",
                                seller.getUsername(),
                                100.0,
                                120.0,
                                "Appliances",
                                false);

                assertTrue(listingId > 0);

                // Record original owner
                calculator.recordOriginalOwner(String.valueOf(listingId), seller.getUsername());

                // Book storage for this item
                storage.requestStorage(String.valueOf(listingId), seller.getUsername(), 4, 3.0); // 12.0 total

                // Buyer purchases the item
                assertTrue(biddingManager.buyNow(listingId, buyer.getUsername()));

                // Pull the real storage fee from the storage service
                double storageFee = storage.getActiveStorageFeeForItem(String.valueOf(listingId));

                FeeCalculator.FeeResult result = calculator.calculateFees(
                                String.valueOf(listingId),
                                seller.getUsername(),
                                120.0,
                                storageFee);

                assertEquals(12.0, result.storageFee, 0.0001);
                assertEquals(12.0, result.platformFee, 0.0001);
                assertEquals(96.0, result.netToSeller, 0.0001);
        }
}