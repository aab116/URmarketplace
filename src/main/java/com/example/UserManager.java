


package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserManager
{

    public boolean register(String username, String email, String password)
    {
        // SQL COMMAND: To insert a new row into the users table
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseHelper.connect(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
            return true; // Successfully registered
            
        } 
        catch (SQLException e)
        {
            return false; // Username exists
        }
    }



    public User login(String username, String password)
    {
        // SQL command to find a user with matching credentials
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        try (Connection conn = DatabaseHelper.connect(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next())
            {
                User user = new User(rs.getString("username"), rs.getString("email"), rs.getString("password"));

                user.setId(rs.getInt("id"));
                user.setLoggedIn(true);

                return user;
            }
            
        } 
        catch (SQLException e)
        {
            System.out.println("Login database error: " + e.getMessage());
        }
        
        return null; // No match found
    }



    public void rateUser(String username, double score)
    {
// SQL command to mathematically add the new score to the existing sum, and bump the count by 1
        String sql = "UPDATE users SET rating_sum = rating_sum + ?, rating_count = rating_count + 1 WHERE username = ?";
        
        try (Connection conn = DatabaseHelper.connect(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setDouble(1, score);
            pstmt.setString(2, username);
            pstmt.executeUpdate();
            
        } 
        catch (SQLException e)
        {
            System.out.println("Error saving rating to database: " + e.getMessage());
        }
    }
}