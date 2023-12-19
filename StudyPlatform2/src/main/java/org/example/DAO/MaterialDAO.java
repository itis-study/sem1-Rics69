package org.example.DAO;

import org.example.model.Material;
import org.example.model.Comment;

import java.util.List;
import java.util.UUID;

public interface MaterialDAO {
    public void addMaterial(Material material);
    void deleteMaterial(UUID materialId);
    public Material getMaterialById(UUID materialId);
    public List<Material> getAllMaterials();
    public List<Material> getMaterialsByUserId(UUID userId);
    public String getUploaderNameById(UUID userId);

     public List<Comment> getCommentsByMaterialId(UUID materialId);
}
