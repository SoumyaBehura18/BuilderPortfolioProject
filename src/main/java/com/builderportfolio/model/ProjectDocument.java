package com.builderportfolio.model;

public class ProjectDocument {
    private int documentId;
    private int projectId;
    private int userId;
    private String fileName;
    private String filePath;

    public ProjectDocument(int projectId, int userId, String fileName, String filePath) {
        this.projectId = projectId;
        this.userId = userId;
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public int getDocumentId() {
        return documentId;
    }
    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }
    public int getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
