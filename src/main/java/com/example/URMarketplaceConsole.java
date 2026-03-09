//____________________________________________________________________________________________
//                              File Description: 

//          Main console application (Command-line interface)
//____________________________________________________________________________________________


package com.example;


import java.util.List;
import java.util.Scanner;


public class URMarketplaceConsole
{
// __________ INITIALIZATIONS __________

// Scanner 
    private final Scanner scanner = new Scanner(System.in); // reads user input  from console
// MANAGERS AND UTILITIES 
    private final UserManager userManager = new UserManager();
    private final BiddingManager biddingManager = new BiddingManager();
    private final IssueManager issueManager = new IssueManager();
    private final ArrangeStorage arrangeStorage = new ArrangeStorageImpl();
    private final FeeCalculator feeCalculator = new TrackOwnerAndCalculateFees(0.05); // 5% platform fee
    private final ModifyItem itemValidator = new ModifyItem();


// __________ USER TRACKING __________
    private User currentUser = null; //


// __________ ENTRY POINT __________
    public static void main(String[] args)    {new URMarketplaceConsole().run();}


// __________ APPLICATION LOOP __________
    public void run()
    {
        System.out.println("=== URMarketplace Console ===");
        
        DatabaseHelper.initializeDatabase();
        DatabaseHelper.seedMockData();

        while (true)
        {
            try 
            {
                if (currentUser == null)  showAuthMenu(); 
                else showMainMenu();
            } 
            catch (Exception e) { System.out.println("\n[Error] " + e.getMessage()); }
        }
    }


// __________ AUTHENTICATION MENU __________
    private void showAuthMenu()
    {
        System.out.println("\n1. Log In to URMarketplace");
        System.out.println("2. Register for URMarketplace");
        System.out.println("0. Exit URMarketplace");
        System.out.print("Choice: ");
        String choice = scanner.nextLine();

        switch (choice)
        {
            case "1":
                doLogin();
                break;
            case "2":
                doRegister();
                break;
            case "0":
                System.out.println("Goodbye.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }


// __________ REGISTRATION __________
    private void doRegister()
    {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        boolean success = userManager.register(username, email, password);

        if (success)    System.out.println("Registration successful.");
        else            System.out.println("Username already taken.");
    }


// __________ LOGIN __________
    private void doLogin()
    {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = userManager.login(username, password);

        if (user != null)
        {
            currentUser = user;
            System.out.println("Welcome, " + currentUser.getUsername() + "!");
        } 
        else  System.out.println("Incorrect login. Check your username and password.");
    }



    // __________ MAIN MENU __________
    private void showMainMenu()
    {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Look for items");
        System.out.println("2. Post item");
        System.out.println("3. Make an offer / Bid");
        System.out.println("4. Buy Now");
        System.out.println("5. Request Item Storage");
        System.out.println("6. Calculate Item Fees/Payout");
        System.out.println("7. Report an issue");
        System.out.println("9. Logout");
        System.out.println("0. Exit");
        System.out.print("Choice: ");

        String choice = scanner.nextLine();

        switch (choice)
        {
            case "1" ->         lookForItems();
            case "2" ->         postItem();
            case "3" ->         makeOffer();
            case "4" ->         buyNow();
            case "5" ->         requestStorage();
            case "6" ->         calculateFees();
            case "7" ->         reportIssue();
            case "9" ->         {       
                                    currentUser.setLoggedIn(false);
                                    currentUser = null;
                                    System.out.println("Logged out.");
                                }
            case "0" ->         {
                                System.out.println("Goodbye.");
                                System.exit(0);
                                }
            default ->          System.out.println("Invalid choice");
        }
    }



// __________ LOOKING THROUGH LISTINGS __________
    private void lookForItems()
    {
        List<Listing> all = biddingManager.getAllListings();

        if (all.isEmpty())
        {
            System.out.println("No items listed.");
            return;
        }

        System.out.println("=== Items ===");

        for (Listing l : all)
        {
            System.out.println("["  +   l.getId() + "] " + l.getTitle() +" - $" + l.getCurrentBid() + " (" + l.getStatus() + ")");
        }
    }



// __________ POST ITEM  __________
    private void postItem()
    {
        System.out.print("Title: ");
        String title = itemValidator.validateAndCleanTitle(scanner.nextLine());

        System.out.print("Description: ");
        String description = itemValidator.validateDescription(scanner.nextLine());

        System.out.print("Starting Price: ");
        double price = itemValidator.validatePrice(Double.parseDouble(scanner.nextLine()));

        System.out.print("Buy Now Price [ If none, 0 ]: ");
        double buyNowPrice = Double.parseDouble(scanner.nextLine());

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Is this an Auction? (True/False): ");
        boolean isAuction = Boolean.parseBoolean(scanner.nextLine());

        int listingId;
        if (buyNowPrice > 0)    listingId = biddingManager.createListingWithBuyNow( title,
                                                                                    description, 
                                                                                    currentUser.getUsername(), 
                                                                                    price, 
                                                                                    buyNowPrice, 
                                                                                    category, 
                                                                                    isAuction );
        else    listingId = biddingManager.createListing(   title, 
                                                            description, 
                                                            currentUser.getUsername(), 
                                                            price, 
                                                            category, 
                                                            isAuction);


// __________ Track the original owner for fee calculations later __________
        ((TrackOwnerAndCalculateFees) feeCalculator).recordOriginalOwner(String.valueOf(listingId), currentUser.getUsername());

        System.out.println("Item posted! Listing ID: " + listingId);
    }



// __________ OFFER ON ITEM __________
    private void makeOffer()
    {
        System.out.print("Enter Listing ID to bid on: ");
        int listId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter bid amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        int status = biddingManager.makeOffer(listId, currentUser.getUsername(), amount);


        if (status > 0)         System.out.println("Bid successful!");
        else if (status == -1)  System.out.println("The listing does not exist.");
        else if (status == -2)  System.out.println("The Listing is not active.");
        else if (status == -3)  System.out.println("The Bid is too low. It must be higher than current bid.");
    }




    private void buyNow()
    {
        System.out.print("Enter Listing ID to Buy Now: ");
        int listId = Integer.parseInt(scanner.nextLine());

        Listing purchasedItem = null;

        for (Listing l : biddingManager.getAllListings())
        {
            if (l.getId() == listId)
            {
                purchasedItem = l;
                break;
            }
        }

        boolean success = biddingManager.buyNow(listId, currentUser.getUsername());

        if (success && purchasedItem != null)
        {
            System.out.println("Congratulations! You just purchased the item.");
            System.out.print("Please rate the seller (" + purchasedItem.getSellerUsername() + ") from 1 to 5: ");

            try
            {
                double score = Double.parseDouble(scanner.nextLine());
                if (score >= 1 && score <= 5)
                {
                    userManager.rateUser(purchasedItem.getSellerUsername(), score);
                    System.out.println("Thank you! Rating saved.");
                } 
                else
                {
                    System.out.println("Invalid rating. Skipping...");
                }
            } 
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Skipping rating...");
            }
        }
        else
        {
            System.out.println("I'm sorry, but your purchase has failed. The Item \n - May not be active \n - Doesn't contain a buy now option");
        }
    }



    private void requestStorage()
    {
        System.out.print("Listing ID to store: ");
        String storeId = itemValidator.requireNonBlankId(scanner.nextLine(), "Listing ID");

        System.out.print("Number of days: ");
        int days = Integer.parseInt(scanner.nextLine());

        System.out.print("Daily rate ($): ");
        double rate = Double.parseDouble(scanner.nextLine());

        String bookingId = arrangeStorage.requestStorage(storeId, currentUser.getUsername(), days, rate);
        System.out.println("Storage booked! Booking ID: " + bookingId);
    }




    private void calculateFees()
    {
        System.out.print("Listing ID to calculate fees for: ");
        String calcId = itemValidator.requireNonBlankId(scanner.nextLine(), "Listing ID");

        // Find the listing to get the sale price
        Listing target = null;
        for (Listing l : biddingManager.getAllListings())
        {
            if (String.valueOf(l.getId()).equals(calcId))
            {
                target = l;
                break;
            }
        }

        if (target == null)
        {
            System.out.println("Listing not found.");
            return;
        }

// *************** Pass 0.0 for storage fee here unless you decide to link ArrangeStorage directly to the listings
        double storageFee = 0.0;

        FeeCalculator.FeeResult result = feeCalculator.calculateFees(calcId, currentUser.getUsername(), target.getCurrentBid(), storageFee);

        System.out.println("\n--- Fee Report for Item #" + calcId + " ---");
        System.out.println("Sale Price: $" + String.format("%.2f", result.salePrice));
        System.out.println("Platform Fee (5%): -$" + String.format("%.2f", result.platformFee));
        System.out.println("Storage Fee: -$" + String.format("%.2f", result.storageFee));
        System.out.println("Net Payout to " + result.originalOwnerUserId + ": $" + String.format("%.2f", result.netToSeller));
    }



    
    private void reportIssue()
    {
        System.out.print("Issue Title: ");
        String title = scanner.nextLine();

        System.out.print("Description: ");
        String desc = scanner.nextLine();

        System.out.print("Category (Technical, Billing, etc.): ");
        String cat = scanner.nextLine();

        int refId = issueManager.reportIssue(title, desc, cat, currentUser.getUsername(), currentUser.getId());

        System.out.println("Issue submitted. Reference ID: " + refId);
    }
}