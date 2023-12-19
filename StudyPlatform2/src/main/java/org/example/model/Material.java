package org.example.model;

import java.util.Date;
import java.util.UUID;

public class Material {
    private UUID materialId;
    private String title;
    private String description;
    private byte[] fileName;
    private String originalFileName;
    private Date uploadDate;
    private UUID userId;

    private String uploaderName;

    public Material(){}

    public Material(UUID materialId, String title, String description, byte[] fileName, Date uploadDate, UUID userId) {
        this.materialId = materialId;
        this.title = title;
        this.description = description;
        this.fileName = fileName;
        this.uploadDate = uploadDate;
        this.userId = userId;
    }

    public UUID getMaterialId() {
        return materialId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getFileName() {
        return fileName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUploaderName() {
        return uploaderName;
    }

    public void setMaterialId(UUID materialId) {
        this.materialId = materialId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFileName(byte[] fileName) {
        this.fileName = fileName;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }
}
