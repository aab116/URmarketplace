package com.example;

// Listing.java - Representa un artículo en venta/subasta
import java.time.LocalDateTime;

public class Listing
{
    private int id;
    private String title;
    private String description;
    private String sellerUsername;
    private double startingPrice;
    private double currentBid;
    private String highestBidder;
    private LocalDateTime endTime;
    private String category;
    private String status; // ACTIVE, SOLD, EXPIRED, CANCELLED
    private boolean isAuction; // true = subasta, false = venta directa
    private double buyNowPrice; // precio de compra directa (opcional)
    
    public Listing() {}
    
    public Listing(String title, String description, String sellerUsername, double startingPrice, String category, boolean isAuction)
    {
        this.title = title;
        this.description = description;
        this.sellerUsername = sellerUsername;
        this.startingPrice = startingPrice;
        this.currentBid = startingPrice;
        this.category = category;
        this.isAuction = isAuction;
        this.status = "ACTIVE";
        this.highestBidder = null;
        this.endTime = LocalDateTime.now().plusDays(7); // 7 días por defecto
    }
    
    // Getters y Setters
    public int getId()        { return id; }
    public void setId(int id) { this.id = id; }
    

    public String getTitle()            { return title; }
    public void setTitle(String title)  { this.title = title; }
    

    public String getDescription()                  { return description; }
    public void setDescription(String description)  { this.description = description; }
    

    public String getSellerUsername()                    { return sellerUsername; }
    public void setSellerUsername(String sellerUsername) { this.sellerUsername = sellerUsername; }
    

    public double getStartingPrice()                   { return startingPrice; }
    public void setStartingPrice(double startingPrice) { this.startingPrice = startingPrice; }
    

    public double getCurrentBid()                { return currentBid; }
    public void setCurrentBid(double currentBid) { this.currentBid = currentBid; }


    public String getHighestBidder()                    { return highestBidder; }
    public void setHighestBidder(String highestBidder)  { this.highestBidder = highestBidder; }
    

    public LocalDateTime getEndTime()             { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    

    public String getCategory()              { return category; }
    public void setCategory(String category) { this.category = category; }
    

    public String getStatus()            { return status; }
    public void setStatus(String status) { this.status = status; }
    

    public boolean isAuction()              { return isAuction; }
    public void setAuction(boolean auction) { isAuction = auction; }
    

    public double getBuyNowPrice()                  { return buyNowPrice; }
    public void setBuyNowPrice(double buyNowPrice)  { this.buyNowPrice = buyNowPrice; }
}