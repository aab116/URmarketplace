package com.example;

// Issue.java - Clase para reporte de problemas
public class Issue
{
    private int id;
    private int StudentId;
    private String title;
    private String description;
    private String category;
    private String status;
    private String reportedBy;
    private String dateReported;
    
    public Issue() {}
    
    public Issue(String title, String description, String category, String reportedBy, int studentId) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.reportedBy = reportedBy;
        this.StudentId = studentId;
        this.status = "OPEN";
    }
    
    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getStudentId(){ return StudentId; }
    public void setStudentId(int studentId){ this.StudentId = studentId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getReportedBy() { return reportedBy; }
    public void setReportedBy(String reportedBy) { this.reportedBy = reportedBy; }
    
    public String getDateReported() { return dateReported; }
    public void setDateReported(String dateReported) { this.dateReported = dateReported; }
}