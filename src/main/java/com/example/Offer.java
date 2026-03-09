package com.example;

// Offer.java - Representa una oferta/puja
import java.time.LocalDateTime;

public class Offer {
    private int id;
    private int listingId;
    private String bidderUsername;
    private double amount;
    private LocalDateTime timestamp;
    private String status; // PENDING, ACCEPTED, REJECTED, OUTBID
    
    public Offer(int listingId, String bidderUsername, double amount) {
        this.listingId = listingId;
        this.bidderUsername = bidderUsername;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.status = "PENDING";
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public int getListingId() { return listingId; }
    public void setListingId(int listingId) { this.listingId = listingId; }
    
    public String getBidderUsername() { return bidderUsername; }
    public void setBidderUsername(String bidderUsername) { this.bidderUsername = bidderUsername; }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}