package org.example.DAO;

import org.example.model.Comment;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommentDAOImpl implements CommentDAO{

    @Override
    public void addComment(Comment comment) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "INSERT INTO Comment (comment_id, text, creation_date, user_id, material_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, comment.getCommentId());
            statement.setString(2, comment.getText());
            statement.setDate(3, new java.sql.Date(comment.getCreationDate().getTime()));
            statement.setObject(4, comment.getUserId());
            statement.setObject(5, comment.getMaterialId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteComment(Comment comment) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM Comment WHERE comment_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, comment.getCommentId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM Comment";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setCommentId(UUID.fromString(resultSet.getString("comment_id")));
                comment.setText(resultSet.getString("text"));
                comment.setCreationDate(resultSet.getDate("creation_date"));
                comment.setUserId(UUID.fromString(resultSet.getString("user_id")));
                comment.setMaterialId(UUID.fromString(resultSet.getString("material_id")));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public List<Comment> getCommentsByMaterialId(UUID materialId) {
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM Comment WHERE material_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setObject(1, materialId, java.sql.Types.OTHER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setCommentId(UUID.fromString(resultSet.getString("comment_id")));
                comment.setText(resultSet.getString("text"));
                comment.setCreationDate(resultSet.getDate("creation_date"));
                comment.setUserId(UUID.fromString(resultSet.getString("user_id")));
                comment.setMaterialId(UUID.fromString(resultSet.getString("material_id")));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
