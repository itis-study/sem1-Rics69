package org.example.model;

import java.util.Date;
import java.util.UUID;

public class Comment {
    private UUID commentId;
    private String text;
    private Date creationDate;
    private UUID userId;
    private UUID materialId;

    public Comment(UUID commentId, String text, Date creationDate, UUID userId, UUID materialId) {
        this.commentId = commentId;
        this.text = text;
        this.creationDate = creationDate;
        this.userId = userId;
        this.materialId = materialId;
    }

    public Comment() {
    }

    public UUID getCommentId() {
        return commentId;
    }

    public String getText() {
        return text;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getMaterialId() {
        return materialId;
    }

    public void setCommentId(UUID commentId) {
        this.commentId = commentId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setMaterialId(UUID materialId) {
        this.materialId = materialId;
    }
}
