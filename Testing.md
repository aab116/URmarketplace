# TESTING.md

## Overview

URMarketplace was validated with JUnit 5 using unit tests, database-backed integration tests, and realistic workflow tests. The test suite covers the validation techniques required for the final design submission: boundary value testing, equivalence class testing, decision table testing, state transition testing, and use case testing.

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

## 6. Integration Testing Subset

A subset of integration tests was performed where business logic interacts with SQLite.

- UserManagerTest
- BiddingManagerTest
- BiddingManagerDecisionTableTest
- IssueManagerTest
- URMarketplaceUseCaseTest
- DatabaseHelperTest

These tests verify that Java service classes correctly persist data, update rows, and retrieve expected records from the database.

## 7. Summary of Coverage

| Required technique | Status | Main evidence |
|---|---|---|
| Boundary value testing | Complete | ModifyItemTest, ArrangeStorageImplTest, TrackOwnerAndCalculateFeesTest |
| Equivalence class testing | Complete | UserManagerTest, ModifyItemTest, ArrangeStorageImplTest, TrackOwnerAndCalculateFeesTest |
| Decision table testing | Complete | BiddingManagerDecisionTableTest |
| State transition testing | Complete | ArrangeStorageImplTest, URMarketplaceUseCaseTest |
| Use case testing | Complete | URMarketplaceUseCaseTest |
