package org.example.servlets;

import org.example.DAO.MaterialDAO;
import org.example.DAO.MaterialDAOImpl;
import org.example.model.UserPlatform;
import org.example.model.Material;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

@WebServlet("/publishMaterial")
@MultipartConfig
public class PublishMaterialServlet extends HttpServlet {
    private MaterialDAO materialDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        materialDAO = new MaterialDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("publish_material.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        UserPlatform user = (UserPlatform) session.getAttribute("user");
        if (!user.getUserType().equals("Teacher")) {
            response.sendRedirect("mainpage");
            return;
        }

        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Part filePart = request.getPart("file");
        byte[] fileBytes = readBytesFromInputStream(filePart.getInputStream());



        Material material = new Material();
        material.setMaterialId(UUID.randomUUID());
        material.setTitle(title);
        material.setDescription(description);
        material.setFileName(fileBytes);
        material.setUploadDate(new Date());
        material.setUserId(user.getUserId());

        materialDAO.addMaterial(material);

        response.sendRedirect("mainpage");
    }

    private byte[] readBytesFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[1024];
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }
}
