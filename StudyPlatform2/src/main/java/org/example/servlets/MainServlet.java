package org.example.servlets;

import org.example.DAO.MaterialDAO;
import org.example.DAO.MaterialDAOImpl;
import org.example.model.Material;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/mainpage")
public class MainServlet extends HttpServlet {
    private final MaterialDAO materialDAO = new MaterialDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Material> materials = materialDAO.getAllMaterials();
        request.setAttribute("materials", materials);
        request.getRequestDispatcher("mainpage.jsp").forward(request, response);
    }
}
