package com.builderportfolio.service;

import com.builderportfolio.dao.DocumentDAO;
import com.builderportfolio.dao.ProjectDao;
import com.builderportfolio.model.Project;
import com.builderportfolio.model.ProjectDocument;
import com.builderportfolio.model.User;
import java.util.List;

public class ProjectServiceImpl {

    private final ProjectDao projectDao;
    private final DocumentDAO documentDao;

    public ProjectServiceImpl(ProjectDao projectDao, DocumentDAO documentDao) {
        this.projectDao = projectDao;
        this.documentDao = documentDao;
    }

    public void createProject(Project project, User currentUser) {
        if (!currentUser.getRole().equals("BUILDER"))
            throw new RuntimeException("Only Builders can create projects");
        projectDao.addProject(project);
    }

    public void updateProject(Project project, User currentUser) {
        if (!currentUser.getRole().equals("PROJECT_MANAGER"))
            throw new RuntimeException("Only Project Managers can update projects");
        projectDao.updateProject(project);
    }

    public void deleteProject(int projectId, User currentUser) {
        if (!currentUser.getRole().equals("PROJECT_MANAGER"))
            throw new RuntimeException("Only Project Managers can delete projects");
        projectDao.deleteProject(projectId);
    }

    public List<Project> viewProjects(User currentUser) { return projectDao.getAllProjects(); }

    public void uploadDocument(ProjectDocument doc, User currentUser) {
        if (!currentUser.getRole().equals("PROJECT_MANAGER"))
            throw new RuntimeException("Only Project Managers can upload documents");
        documentDao.addDocument(doc);
    }

    public List<ProjectDocument> getDocumentsForProject(int projectId) {
        return documentDao.getDocumentsByProjectId(projectId); }
}
