package com.builderportfolio.model;

public class Project {
    private int projectId;
    private String projectName;
    private int builderId;
    private int clientId;
    private int managerId;
    private double budget;
    private double actualSpend;
    private String status;

    public Project(String projectName, int builderId, int clientId, int managerId, double budget) {
        this.projectName = projectName;
        this.builderId = builderId;
        this.clientId = clientId;
        this.managerId = managerId;
        this.budget = budget;
        this.actualSpend = 0;
        this.status = "UPCOMING";
    }

    public Project(int projectId, String projectName, int builderId, int clientId, int managerId, double budget,
                   double actualSpend, String status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.builderId = builderId;
        this.clientId = clientId;
        this.managerId = managerId;
        this.budget = budget;
        this.actualSpend = actualSpend;
        this.status = status;
    }

    public int getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public int getBuilderId() {
        return builderId;
    }
    public void setBuilderId(int builderId) {
        this.builderId = builderId;
    }
    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public int getManagerId() {
        return managerId;
    }
    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public double getActualSpend() {
        return actualSpend;
    }
    public void setActualSpend(double actualSpend) {
        this.actualSpend = actualSpend;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void addExpense(double amount) { this.actualSpend += amount; }
}
