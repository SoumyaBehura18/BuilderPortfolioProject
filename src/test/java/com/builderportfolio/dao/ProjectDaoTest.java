package com.builderportfolio.dao;

import com.builderportfolio.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ProjectDaoTest {

    private ProjectDao projectDao;

    @BeforeEach
    void setUp() {
        projectDao = new ProjectDao();
    }

    @Test
    void addProjectTest() {
        Project project = new Project("Test Project", 1, 2, 3, 100000);
        assertDoesNotThrow(() -> projectDao.addProject(project));
    }

    @Test
    void getAllProjectsTest() {
        Project project = new Project("List Test", 1, 2, 3, 50000);
        projectDao.addProject(project);

        List<Project> projects = projectDao.getAllProjects();
        assertNotNull(projects);
        assertTrue(projects.size() > 0);
    }

    @Test
    void updateProjectTest() {
        Project project = new Project("Update Test", 1, 2, 3, 75000);
        projectDao.addProject(project);
        project.setStatus("IN_PROGRESS");
        assertDoesNotThrow(() -> projectDao.updateProject(project));
    }

    @Test
    void deleteProjectTest() {
        Project project = new Project("Delete Test", 1, 2, 3, 50000);
        projectDao.addProject(project);
        int idToDelete = project.getProjectId(); // Assuming ID is set after addProject
        assertDoesNotThrow(() -> projectDao.deleteProject(idToDelete));
    }
}
