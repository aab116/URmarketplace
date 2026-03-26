package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IssueTest {

    @Test
    void constructorSetsFieldsAndDefaultsStatusToOpen() {
        // Create a new issue using the full constructor.
        Issue issue = new Issue("Login issue", "Cannot sign in", "Technical", "Amr", 200506317);

        // The constructor should copy all the given values.
        assertEquals("Login issue", issue.getTitle());
        assertEquals("Cannot sign in", issue.getDescription());
        assertEquals("Technical", issue.getCategory());
        assertEquals("Amr", issue.getReportedBy());
        assertEquals(200506317, issue.getStudentId());

        // A brand new issue should start in OPEN status.
        assertEquals("OPEN", issue.getStatus());

        // This constructor does not appear to assign a report date.
        assertNull(issue.getDateReported());
    }

    @Test
    void settersAndGettersRoundTripValues() {
        // Start with the empty constructor, then fill in each field manually.
        Issue issue = new Issue();

        issue.setId(10);
        issue.setStudentId(123456);
        issue.setTitle("Payment issue");
        issue.setDescription("Fee mismatch");
        issue.setCategory("Billing");
        issue.setStatus("CLOSED");
        issue.setReportedBy("Cobie");
        issue.setDateReported("2026-03-25");

        // Every getter should return the exact value that was set.
        assertEquals(10, issue.getId());
        assertEquals(123456, issue.getStudentId());
        assertEquals("Payment issue", issue.getTitle());
        assertEquals("Fee mismatch", issue.getDescription());
        assertEquals("Billing", issue.getCategory());
        assertEquals("CLOSED", issue.getStatus());
        assertEquals("Cobie", issue.getReportedBy());
        assertEquals("2026-03-25", issue.getDateReported());
    }
}
