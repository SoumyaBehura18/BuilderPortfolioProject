package com.builderportfolio.service;

import com.builderportfolio.dao.ProjectDao;
import com.builderportfolio.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjectServiceImplTest {

    @Mock
    private ProjectDao projectDao;

    @InjectMocks
    private ProjectServiceImpl projectService;

    private User builder;
    private User manager;
    private User client;
    private Project project;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        builder = new User(1, "builder1", "builder@gmail.com", "pass123", "BUILDER");
        manager = new User(2, "manager1", "manager@gmail.com", "pass345", "PROJECT_MANAGER");
        client = new User(3, "client1", "client@gmail.com", "pass678", "CLIENT");

        project = new Project("Mall Project", builder.getUserId(), client.getUserId(), manager.getUserId(), 1000000);
    }

    @Test
    void testCreateProject() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> projectService.createProject(project, client));
        assertEquals("Only Builders can create projects", exception.getMessage());
    }

    @Test
    void testUpdateProject() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> projectService.updateProject(project, builder));
        assertEquals("Only Project Managers can update projects", exception.getMessage());
    }

    @Test
    void testViewProjects() {
        List<Project> mockProjects = Arrays.asList(project);
        when(projectDao.getAllProjects()).thenReturn(mockProjects);

        List<Project> resultBuilder = projectService.viewProjects(builder);
        List<Project> resultManager = projectService.viewProjects(manager);
        List<Project> resultClient = projectService.viewProjects(client);

        assertEquals(1, resultBuilder.size());
        assertEquals(1, resultManager.size());
        assertEquals(1, resultClient.size());
    }


}
