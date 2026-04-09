//_____________________________________________________________________________________________________
//                              File Description: 

// Medium that sets up & initializes database (SQLite) with the tables for users, listings, and issues
//_____________________________________________________________________________________________________


package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper
{

// File created in root directory, named: 'marketplace.db'
    private static final String URL = "jdbc:sqlite:marketplace.db"; 


// Method to get a fresh connection to the database
    public static Connection connect() throws SQLException    { return DriverManager.getConnection(URL); }


// Method to build all our tables if they don't exist yet
    public static void initializeDatabase()
    {
        try (Connection conn = connect(); Statement stmt = conn.createStatement())
        {
// 1 - Create Users Table
            stmt.execute("CREATE TABLE IF NOT EXISTS users ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "username TEXT UNIQUE, "
                    + "email TEXT, "
                    + "password TEXT, "
                    + "rating_sum REAL DEFAULT 0, "
                    + "rating_count INTEGER DEFAULT 0"
                    + ");");

// 2 - Create Listings Table
            stmt.execute("CREATE TABLE IF NOT EXISTS listings ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "title TEXT, description TEXT, "
                    + "sellerUsername TEXT, originalOwnerUsername TEXT, "
                    + "startingPrice REAL, currentBid REAL, buyNowPrice REAL, "
                    + "highestBidder TEXT, "
                    + "category TEXT, status TEXT, isAuction BOOLEAN"
                    + ");");

// 3 - Create Issues Table
            stmt.execute( "CREATE TABLE IF NOT EXISTS issues ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "title TEXT, description TEXT, category TEXT, "
                        + "reportedBy TEXT, studentId INTEGER, status TEXT"
                        + ");");

            System.out.println("Database hooked up and tables are ready!");

        } 
        catch (SQLException e)        { System.out.println("Error initializing database: " + e.getMessage()); }
    }




// Method to populate the database with fake data if it's empty
public static void seedMockData()
{
    // Make sure the tables exist before trying to seed them
    initializeDatabase();

    String checkSql = "SELECT COUNT(*) FROM users";

    try (Connection conn = connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(checkSql))
    {
        // Only inject data if the users table is completely empty
        if (rs.next() && rs.getInt(1) == 0)
        {
            System.out.println("Empty database detected. Populating with mock data...");

            // 1. Mock Users (Passwords are all 'password123')
            stmt.execute("INSERT INTO users (username, email, password, rating_sum, rating_count) VALUES ('alice_smith', 'alice@uregina.ca', 'password123', 18, 4)");
            stmt.execute("INSERT INTO users (username, email, password, rating_sum, rating_count) VALUES ('tech_guru', 'tech@uregina.ca', 'password123', 25, 5)");
            stmt.execute("INSERT INTO users (username, email, password, rating_sum, rating_count) VALUES ('plant_lover', 'plants@uregina.ca', 'password123', 5, 1)");

            // 2. Mock Marketplace Listings
            stmt.execute(
                "INSERT INTO listings (title, description, sellerUsername, originalOwnerUsername, startingPrice, currentBid, buyNowPrice, highestBidder, category, status, isAuction) "
                + "VALUES ('2005 Subaru Outback 3.0R', 'Runs great, well maintained.', 'alice_smith', 'alice_smith', 4500.0, 4500.0, 5000.0, NULL, 'Vehicles', 'ACTIVE', true)");

            stmt.execute(
                "INSERT INTO listings (title, description, sellerUsername, originalOwnerUsername, startingPrice, currentBid, buyNowPrice, highestBidder, category, status, isAuction) "
                + "VALUES ('STM32F103RB Microcontroller', 'Perfect for ENEL lab assignments.', 'tech_guru', 'tech_guru', 15.0, 15.0, 20.0, NULL, 'Electronics', 'ACTIVE', false)");

            stmt.execute(
                "INSERT INTO listings (title, description, sellerUsername, originalOwnerUsername, startingPrice, currentBid, buyNowPrice, highestBidder, category, status, isAuction) "
                + "VALUES ('Lenovo ThinkPad T15 Gen 1', 'Good condition, minor wear.', 'tech_guru', 'tech_guru', 300.0, 300.0, 400.0, NULL, 'Computers', 'ACTIVE', true)");

            stmt.execute(
                "INSERT INTO listings (title, description, sellerUsername, originalOwnerUsername, startingPrice, currentBid, buyNowPrice, highestBidder, category, status, isAuction) "
                + "VALUES ('Aquarium Air Pump', 'Quiet and reliable, comes with tubing.', 'plant_lover', 'plant_lover', 10.0, 10.0, 15.0, NULL, 'Pets', 'ACTIVE', false)");

            stmt.execute(
                "INSERT INTO listings (title, description, sellerUsername, originalOwnerUsername, startingPrice, currentBid, buyNowPrice, highestBidder, category, status, isAuction) "
                + "VALUES ('Strelitzia nicolai (White Bird of Paradise)', 'Healthy house plant, needs good light.', 'plant_lover', 'plant_lover', 45.0, 45.0, 50.0, NULL, 'Home & Garden', 'ACTIVE', false)");

            // 3. Mock Issues
            stmt.execute("INSERT INTO issues (title, description, category, reportedBy, studentId, status) VALUES ('Bidding Error', 'Cannot place bid on the laptop.', 'Technical', 'alice_smith', 123456, 'OPEN')");

            System.out.println("Mock data successfully loaded!");
        }

    }
    catch (SQLException e)
    {
        System.out.println("Error seeding data: " + e.getMessage());
    }
}
}
