package com.builderportfolio.service;

import com.builderportfolio.model.Project;
import com.builderportfolio.model.ProjectStatus;

import java.util.List;

public interface ProjectService {
    void createProject(Project project);
    void changeStatus(int projectId, ProjectStatus status);
    void addExpense(int projectId, double amount);
    List<Project> listProjects();
}
