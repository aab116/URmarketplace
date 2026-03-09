package com.example;


public class User
{
    private int id;
    private String username;
    private String email;
    private String password;
    private boolean isLoggedIn;
    private double ratingSum = 0;
    private int ratingCount = 0;
    
    public User() {}
    
    public User(String username, String email, String password)
    {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isLoggedIn = false;
    }
    
    // Getters y Setters
    public int getId()          { return id; }
    public void setId(int id)   { this.id = id; }
    
    


    public String getUsername()                 { return username; }
    public void setUsername(String username)    { this.username = username; }
    
    public String getEmail()            { return email; }
    public void setEmail(String email)  { this.email = email; }
    
    public String getPassword()              { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public boolean isLoggedIn()                 { return isLoggedIn; }
    public void setLoggedIn(boolean loggedIn)   { isLoggedIn = loggedIn; }


    public void addRating(double score)
    {
        this.ratingSum += score;
        this.ratingCount++;
    }

    public double getAverageRating()
    {
        if (ratingCount == 0)
        {
            return 0.0;
        }
        return ratingSum / ratingCount;
    }
}