package org.example.DAO;

import org.example.model.Comment;
import org.example.model.Material;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MaterialDAOImpl implements MaterialDAO{
    @Override
    public void addMaterial(Material material) {
        String query = "INSERT INTO Material (material_id, title, description, file_name, original_file_name, upload_date, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBUtil.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setObject(1, material.getMaterialId());
                statement.setString(2, material.getTitle());
                statement.setString(3, material.getDescription());
                statement.setBytes(4, material.getFileName());
                statement.setString(5, material.getOriginalFileName());
                statement.setDate(6, new java.sql.Date(material.getUploadDate().getTime()));
                statement.setObject(7, material.getUserId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMaterial(UUID materialId) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM Material WHERE material_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setObject(1, materialId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Material> getAllMaterials() {
        List<Material> materials = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT Material.*, UserPlatform.first_name, UserPlatform.last_name " +
                    "FROM Material " +
                    "JOIN UserPlatform ON Material.user_id = UserPlatform.user_id";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Material material = new Material();
                material.setMaterialId(UUID.fromString(resultSet.getString("material_id")));
                material.setTitle(resultSet.getString("title"));
                material.setDescription(resultSet.getString("description"));
                material.setFileName(resultSet.getBytes("file_name"));
                material.setOriginalFileName(resultSet.getString("original_file_name"));
                material.setUploadDate(resultSet.getDate("upload_date"));
                material.setUserId(UUID.fromString(resultSet.getString("user_id")));

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                material.setUploaderName(firstName + " " + lastName);

                materials.add(material);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materials;
    }

    @Override
    public Material getMaterialById(UUID materialId) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM Material WHERE material_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, materialId, java.sql.Types.OTHER);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Material material = new Material();
                material.setMaterialId(UUID.fromString(resultSet.getString("material_id")));
                material.setTitle(resultSet.getString("title"));
                material.setDescription(resultSet.getString("description"));
                material.setFileName(resultSet.getBytes("file_name"));
                material.setOriginalFileName(resultSet.getString("original_file_name"));
                material.setUploadDate(resultSet.getDate("upload_date"));
                material.setUserId(UUID.fromString(resultSet.getString("user_id")));
                return material;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Material> getMaterialsByUserId(UUID userId) {
        List<Material> materials = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM Material WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, userId, java.sql.Types.OTHER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Material material = new Material();
                material.setMaterialId(UUID.fromString(resultSet.getString("material_id")));
                material.setTitle(resultSet.getString("title"));
                material.setDescription(resultSet.getString("description"));
                material.setFileName(resultSet.getBytes("file_name"));
                material.setOriginalFileName(resultSet.getString("original_file_name"));
                material.setUploadDate(resultSet.getDate("upload_date"));
                material.setUserId(UUID.fromString(resultSet.getString("user_id")));
                materials.add(material);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materials;
    }

    @Override
    public String getUploaderNameById(UUID userId) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT first_name, last_name FROM UserPlatform WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setObject(1, userId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        return firstName + " " + lastName;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsByMaterialId(UUID materialId) {
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM Comment WHERE material_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setObject(1, materialId, java.sql.Types.OTHER);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Comment comment = new Comment();
                    comment.setCommentId(UUID.fromString(resultSet.getString("comment_id")));
                    comment.setText(resultSet.getString("text"));
                    comment.setCreationDate(resultSet.getDate("creation_date"));
                    comment.setMaterialId(UUID.fromString(resultSet.getString("material_id")));
                    comments.add(comment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
