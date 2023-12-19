package org.example.servlets;

import org.example.DAO.MaterialDAO;
import org.example.DAO.MaterialDAOImpl;
import org.example.model.Material;
import org.example.model.UserPlatform;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/deleteMaterial")
public class DeleteMaterialServlet extends HttpServlet {
    private MaterialDAO materialDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        materialDAO = new MaterialDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserPlatform user = (UserPlatform) session.getAttribute("user");

        if (user != null && user.getUserType().equals("Teacher")) {
            List<Material> materials = materialDAO.getMaterialsByUserId(user.getUserId());
            request.setAttribute("materials", materials);
            request.getRequestDispatcher("delete_material.jsp").forward(request, response);
        } else {
            response.sendRedirect("mainpage");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] materialIds = request.getParameterValues("materialIds");

        if (materialIds != null && materialIds.length > 0) {
            for (String materialId : materialIds) {
                UUID uuid = UUID.fromString(materialId);
                materialDAO.deleteMaterial(uuid);
            }
        }

        response.sendRedirect("mainpage");
    }
}