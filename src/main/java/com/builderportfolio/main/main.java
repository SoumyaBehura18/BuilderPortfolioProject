package com.builderportfolio.main;

import com.builderportfolio.exceptions.InvalidUserException;
import com.builderportfolio.model.Project;
import com.builderportfolio.model.ProjectDocument;
import com.builderportfolio.model.User;
import com.builderportfolio.service.AuthenticationServiceImpl;
import com.builderportfolio.service.ProjectServiceImpl;
import com.builderportfolio.dao.DocumentDAO;
import com.builderportfolio.dao.ProjectDao;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AuthenticationServiceImpl authService = new AuthenticationServiceImpl();
        ProjectServiceImpl projectService = new ProjectServiceImpl(new ProjectDao(), new DocumentDAO());

        User currentUser = null;

        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Username: ");
                String username = sc.nextLine();
                System.out.print("Email: ");
                String email = sc.nextLine();
                System.out.print("Password: ");
                String password = sc.nextLine();
                System.out.print("Role (BUILDER/PROJECT_MANAGER/CLIENT): ");
                String role = sc.nextLine();
                authService.register(new User(username, email, password, role));
                System.out.println("Registered Successfully!");
            } else if (choice == 2) {
                System.out.print("Username: ");
                String username = sc.nextLine();
                System.out.print("Password: ");
                String password = sc.nextLine();
                try {
                    currentUser = authService.login(username, password);
                    System.out.println("Login successful, Welcome " + currentUser.getUsername());
                } catch (InvalidUserException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else break;

            if (currentUser != null) {
                boolean logout = false;
                while (!logout) {
                    System.out.println("1. Add Project\n2. Update Project\n3. Delete Project\n4. View Projects\n5. Upload Document\n6. Logout");
                    int action = sc.nextInt();
                    sc.nextLine();

                    switch (action) {
                        case 1 -> {
                            System.out.print("Project Name: ");
                            String name = sc.nextLine();
                            System.out.print("Client ID: ");
                            int clientId = sc.nextInt();
                            System.out.print("Manager ID: ");
                            int managerId = sc.nextInt(); sc.nextLine();
                            System.out.print("Budget: ");
                            double budget = sc.nextDouble(); sc.nextLine();
                            Project p = new Project(name, currentUser.getUserId(), clientId, managerId, budget);
                            projectService.createProject(p, currentUser);
                            System.out.println("Project added");
                        }

                        case 2 -> {
                            System.out.print("Project ID to update: ");
                            int pid = sc.nextInt(); sc.nextLine();
                            List<Project> projects = projectService.viewProjects(currentUser);
                            Project proj = projects.stream().filter(pr -> pr.getProjectId() == pid).findFirst().orElse(null);
                            if (proj != null) {
                                System.out.print("New Status (UPCOMING/IN_PROGRESS/COMPLETED): ");
                                String status = sc.nextLine();
                                proj.setStatus(status);
                                System.out.print("Add expense: ");
                                double exp = sc.nextDouble(); sc.nextLine();
                                proj.addExpense(exp);
                                projectService.updateProject(proj, currentUser);
                                System.out.println("Project updated");
                            }
                            else System.out.println("Project not found");
                        }

                        case 3 -> {
                            System.out.print("Project ID to delete: "); int pid = sc.nextInt(); sc.nextLine();
                            projectService.deleteProject(pid, currentUser);
                            System.out.println("Project deleted");
                        }

                        case 4 -> {
                            List<Project> projects = projectService.viewProjects(currentUser);
                            System.out.println("Projects:");
                            for (Project pr : projects)
                                System.out.println(pr.getProjectId() + " - " + pr.getProjectName() + " | Status: " + pr.getStatus() + " | Spend: " + pr.getActualSpend());
                        }

                        case 5 -> {
                            System.out.print("Project ID: "); int pid = sc.nextInt(); sc.nextLine();
                            System.out.print("File Name: "); String fileName = sc.nextLine();
                            System.out.print("File Path: "); String filePath = sc.nextLine();
                            ProjectDocument doc = new ProjectDocument(pid, currentUser.getUserId(), fileName, filePath);
                            projectService.uploadDocument(doc, currentUser);
                            System.out.println("Document uploaded");
                        }

                        case 6 -> logout = true;
                        default -> System.out.println("Invalid choice");
                    }
                }
            }
        }
        sc.close();
        System.out.println("Exiting the application, thank you.");
    }
}
