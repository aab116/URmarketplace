package com.example;



// Stores issues in: private final List<String> issues = new ArrayList<>();



import java.util.ArrayList;
import java.util.List;

public class IssueRepository {

    private final List<String> issues = new ArrayList<>();

    public int saveIssue(String reporterEmail, String description) {
        String entry = "From: " + reporterEmail + " | " + description;
        issues.add(entry);
        return issues.size();
    }
}
