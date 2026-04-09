# TESTING.md

## Overview

URMarketplace was validated with JUnit 5 using unit tests, database-backed integration tests, and realistic workflow tests. The test suite covers the validation techniques required for the final design submission: boundary value testing, equivalence class testing, decision table testing, state transition testing, use case testing, path testing, and data flow testing.

## 1. Boundary Value Testing

Boundary testing focuses on values at or just beyond allowed limits.

- ModifyItemTest
  - rejects titles longer than MAX_TITLE_LENGTH + 1
  - rejects descriptions longer than MAX_DESCRIPTION_LENGTH + 1
  - rejects prices at 0, negative values, NaN, and infinity
  - allows bidding price 0.0 as the lower valid boundary

- ArrangeStorageImplTest
  - rejects days = 0 and negative day counts
  - rejects negative daily rates

- TrackOwnerAndCalculateFeesTest
  - rejects salePrice = 0, negative or invalid storage fees, and invalid numeric values

- BiddingManagerDecisionTableTest
  - checks the equal-boundary case where a bid equal to the current bid is rejected

## 2. Equivalence Class Testing

Inputs were partitioned into valid and invalid classes.

- UserManagerTest
  - valid class: new username/password/email combination
  - invalid class: duplicate username
  - valid class: correct login credentials
  - invalid class: wrong password or missing username

- ModifyItemTest
  - valid class: non-empty trimmed title within max length
  - invalid class: null, blank, or over-length title
  - valid class: positive price
  - invalid class: zero, negative, or non-finite price

- ArrangeStorageImplTest
  - valid class: non-blank item and user IDs with positive days and non-negative rate
  - invalid class: blank IDs, zero or negative days, negative rate

- TrackOwnerAndCalculateFeesTest
  - valid class: non-blank IDs, positive sale price, non-negative storage fee
  - invalid class: blank IDs, non-finite values, negative fees

## 3. Decision Table Testing

Decision table testing was applied to business rules with multiple conditions and outcomes.

### 3.1 makeOffer() decision table

| Rule | Listing exists | Listing ACTIVE | Amount > current bid | Expected result |
|---|---|---|---|---|
| 1 | No | - | - | return -1 |
| 2 | Yes | No | - | return -2 |
| 3 | Yes | Yes | No (lower) | return -3 |
| 4 | Yes | Yes | No (equal) | return -3 |
| 5 | Yes | Yes | Yes | return 1, update bid and highest bidder |

Covered by BiddingManagerDecisionTableTest.makeOfferDecisionTableCoversMissingInactiveLowEqualAndValidCases().

### 3.2 buyNow() decision table

| Rule | Listing exists | Listing ACTIVE | buyNowPrice > 0 | Expected result |
|---|---|---|---|---|
| 1 | No | - | - | false |
| 2 | Yes | Yes | No | false |
| 3 | Yes | No | Yes | false |
| 4 | Yes | Yes | Yes | true, listing becomes SOLD |

Covered by BiddingManagerDecisionTableTest.buyNowDecisionTableCoversMissingInactiveNoPriceAndValidCases().

## 4. State Transition Testing

State transition testing checks whether the system moves between valid states and rejects invalid repeated actions.

- ArrangeStorageImplTest
  - ACTIVE to CANCELLED when a valid booking is cancelled
  - second cancel attempt stays invalid and returns false

- URMarketplaceUseCaseTest
  - listing begins in ACTIVE
  - successful buy-now transitions listing to SOLD
  - once SOLD, the listing no longer appears in active category search results

- BiddingManagerDecisionTableTest
  - inactive listings reject new bids with -2

## 5. Use Case Testing

Use case testing validates complete user workflows across multiple components.

- URMarketplaceUseCaseTest.useCaseBuyerPurchasesItemAndSellerFeesAreCalculated()
  - register seller and buyer
  - log both users in
  - create listing
  - search listing by category
  - complete purchase with buy now
  - verify SOLD state and buyer assignment
  - calculate seller payout after fees

- URMarketplaceUseCaseTest.useCaseUserReportsIssueAndAdminCanRetrieveIt()
  - register user
  - log in
  - submit issue report
  - retrieve issue from the system and verify stored data

## 6. Path Testing

Path testing was applied to BiddingManager.makeOffer(int listingId, String bidderUsername, double amount) because it contains multiple control-flow branches with distinct outcomes.

The main execution paths are:

Path 1: listing does not exist, return -1
Path 2: listing exists but is not ACTIVE, return -2
Path 3: listing exists, is ACTIVE, but bid amount is less than or equal to the current bid, return -3
Path 4: listing exists, is ACTIVE, and bid amount is greater than the current bid, update the current bid and highest bidder, then return 1

These paths are covered by the dedicated path-based tests in BiddingManagerPathTest:

path1_listingDoesNotExist_returnsMinus1()
path2_listingExistsButNotActive_returnsMinus2()
path3_listingIsActiveButBidTooLow_returnsMinus3()
path4_listingIsActiveAndBidIsHigher_returns1AndUpdatesDatabase()

This ensures that each major branch and outcome in makeOffer() is exercised directly through path-based testing.

## 7. Data Flow Testing

Data flow testing was applied to BiddingManager.makeOffer(int listingId, String bidderUsername, double amount) because the function reads values from inputs and from the database, uses them in control decisions, and then writes updated values back to the database on the success path.

The main definition-use pairs are:

- listingId is defined as a method input and used in the SELECT query to retrieve the listing row
- status is defined from the database result and used in the ACTIVE status check
- currentBid is defined from the database result and used in the bid comparison against amount
- amount is defined as a method input and used in both the comparison and the UPDATE statement
- bidderUsername is defined as a method input and used in the UPDATE statement for highestBidder

These definition-use pairs are covered by the dedicated data-flow tests in BiddingManagerDataFlowTest:

- duPair_listingIdUsedInSelect_missingListing_returnsMinus1()
- duPair_statusDefinedFromDatabase_usedInActiveCheck_returnsMinus2()
- duPair_currentBidDefinedFromDatabase_usedInComparison_returnsMinus3()
- duPair_amountAndBidderUsername_usedInUpdate_persistCorrectValues()

This verifies that important values are properly defined, used in decision points, and carried into the final database update when a valid bid is made.

## 8. Integration Testing Subset

A subset of integration tests was performed where business logic interacts with SQLite.

- UserManagerTest
- BiddingManagerTest
- BiddingManagerDecisionTableTest
- BiddingManagerPathTest
- BiddingManagerDataFlowTest
- IssueManagerTest
- URMarketplaceUseCaseTest
- DatabaseHelperTest

These tests verify that Java service classes correctly persist data, update rows, and retrieve expected records from the database.

## 9. Summary of Coverage

| Required technique | Status | Main evidence |
|---|---|---|
| Boundary value testing | Complete | ModifyItemTest, ArrangeStorageImplTest, TrackOwnerAndCalculateFeesTest |
| Equivalence class testing | Complete | UserManagerTest, ModifyItemTest, ArrangeStorageImplTest, TrackOwnerAndCalculateFeesTest |
| Decision table testing | Complete | BiddingManagerDecisionTableTest |
| State transition testing | Complete | ArrangeStorageImplTest, URMarketplaceUseCaseTest |
| Use case testing | Complete | URMarketplaceUseCaseTest |
| Path testing | Complete | BiddingManagerPathTest |
| Data flow testing | Complete | BiddingManagerDataFlowTest |


