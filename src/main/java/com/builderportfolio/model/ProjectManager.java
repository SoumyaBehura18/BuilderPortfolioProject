package com.builderportfolio.model;

public class ProjectManager extends User {
    public ProjectManager(int userId, String username, String email, String password) {
        super(userId, username, email, password, "PROJECT_MANAGER");
    }
}
