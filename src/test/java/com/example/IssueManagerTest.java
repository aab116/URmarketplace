package com.example;



import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class IssueManagerTest
{

    private IssueManager issueManager;



    @BeforeEach
    public void setUp()
    {
        DatabaseHelper.initializeDatabase();

        // Clear the issues table before each test for a blank slate
        try (Connection conn = DatabaseHelper.connect(); Statement stmt = conn.createStatement())
        {
            stmt.execute("DELETE FROM issues");
        }
        catch (Exception e)
        {
            System.out.println("Could not clear database: " + e.getMessage());
        }

        issueManager = new IssueManager();
    }



    @Test
    public void testReportIssue()
    {
        String studentName = "Alice Smith";
        int studentId = 998877;
        String problem = "Cannot place bid on item #5";

        int id = issueManager.reportIssue("Bidding Error", problem, "Technical", studentName, studentId);

        assertTrue(id > 0, "Issue should be successfully reported and return a valid ID");

        // NOW this line will work perfectly!
        Issue report = issueManager.getAllIssues().get(0);

        assertEquals("Bidding Error", report.getTitle());
        assertEquals(998877, report.getStudentId());
    }
}
