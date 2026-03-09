package com.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IssueManager {



    public int reportIssue(String title, String description, String category, String studentName, int studentId)
    {
        String sql = "INSERT INTO issues (title, description, category, reportedBy, studentId, status) VALUES (?, ?, ?, ?, ?, 'OPEN')";

        try (Connection conn = DatabaseHelper.connect(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setString(3, category);
            pstmt.setString(4, studentName);
            pstmt.setInt(5, studentId);

            pstmt.executeUpdate();

            // Return the generated Issue ID
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error reporting issue: " + e.getMessage());
        }
        return -1;
    }



    public List<Issue> getAllIssues()
    {
        List<Issue> issues = new ArrayList<>();
        String sql = "SELECT * FROM issues";
        
        try (Connection conn = DatabaseHelper.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            
            while (rs.next())
            {
                Issue issue = new Issue(
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("category"),
                    rs.getString("reportedBy"),
                    rs.getInt("studentId")
                );

                issue.setId(rs.getInt("id"));
                issues.add(issue);
            }
        } 
        catch (SQLException e)
        {
            System.out.println("Error fetching issues: " + e.getMessage());
        }
        
        return issues;
    }
}
