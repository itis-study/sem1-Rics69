package org.example.servlets;

import org.example.DAO.MaterialDAO;
import org.example.DAO.MaterialDAOImpl;
import org.example.model.Material;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/downloadMaterial")
public class DownloadMaterialServlet extends HttpServlet {
    private MaterialDAO materialDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        materialDAO = new MaterialDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String materialIdString = request.getParameter("materialId");
        if (materialIdString != null && !materialIdString.isEmpty()) {
            UUID materialId = UUID.fromString(materialIdString);
            Material material = materialDAO.getMaterialById(materialId);

            if (material != null) {
                response.setContentType("application/octet-stream");

                String originalFileName = "material";
                if (material.getOriginalFileName() != null && !material.getOriginalFileName().isEmpty()) {
                    originalFileName = material.getOriginalFileName();
                }
                response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFileName + "\"");

                try (ServletOutputStream out = response.getOutputStream()) {
                    out.write(material.getFileName());
                }
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}

