package org.example.DAO;

import org.example.model.Comment;

import java.util.List;
import java.util.UUID;

public interface CommentDAO {
    public void addComment(Comment comment);
    public void deleteComment(Comment comment);
    public List<Comment> getAllComments();
    public List<Comment> getCommentsByMaterialId(UUID materialId);
}
