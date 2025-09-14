package com.builderportfolio.dao;

import com.builderportfolio.model.Project;
import com.builderportfolio.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {

    public void addProject(Project project) {
        String sql = "INSERT INTO projects (project_name, builder_id, client_id, manager_id, budget, actual_spend, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, project.getProjectName());
            stmt.setInt(2, project.getBuilderId());
            stmt.setInt(3, project.getClientId());
            stmt.setInt(4, project.getManagerId());
            stmt.setDouble(5, project.getBudget());
            stmt.setDouble(6, project.getActualSpend());
            stmt.setString(7, project.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM projects";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Project project = new Project(
                        rs.getInt("project_id"),
                        rs.getString("project_name"),
                        rs.getInt("builder_id"),
                        rs.getInt("client_id"),
                        rs.getInt("manager_id"),
                        rs.getDouble("budget"),
                        rs.getDouble("actual_spend"),
                        rs.getString("status")
                );
                projects.add(project);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return projects;
    }

    public void updateProject(Project project) {
        String sql = "UPDATE projects SET project_name=?, builder_id=?, client_id=?, manager_id=?, budget=?, actual_spend=?, status=? WHERE project_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, project.getProjectName());
            stmt.setInt(2, project.getBuilderId());
            stmt.setInt(3, project.getClientId());
            stmt.setInt(4, project.getManagerId());
            stmt.setDouble(5, project.getBudget());
            stmt.setDouble(6, project.getActualSpend());
            stmt.setString(7, project.getStatus());
            stmt.setInt(8, project.getProjectId());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void deleteProject(int projectId) {
        String sql = "DELETE FROM projects WHERE project_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, projectId);
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
