package com.builderportfolio.dao;

import com.builderportfolio.model.ProjectDocument;
import com.builderportfolio.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentDAO {

    public void addDocument(ProjectDocument doc) {
        String sql = "INSERT INTO project_documents (project_id, user_id, file_name, file_path) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, doc.getProjectId());
            stmt.setInt(2, doc.getUserId());
            stmt.setString(3, doc.getFileName());
            stmt.setString(4, doc.getFilePath());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public List<ProjectDocument> getDocumentsByProjectId(int projectId) {
        List<ProjectDocument> docs = new ArrayList<>();
        String sql = "SELECT * FROM project_documents WHERE project_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, projectId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ProjectDocument doc = new ProjectDocument(
                            rs.getInt("project_id"),
                            rs.getInt("user_id"),
                            rs.getString("file_name"),
                            rs.getString("file_path")
                    );
                    docs.add(doc);
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return docs;
    }
}
