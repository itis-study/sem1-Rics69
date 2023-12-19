package org.example.servlets;

import org.example.DAO.CommentDAO;
import org.example.DAO.CommentDAOImpl;
import org.example.DAO.MaterialDAO;
import org.example.DAO.MaterialDAOImpl;
import org.example.model.Comment;
import org.example.model.Material;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet("/material")
public class MaterialServlet extends HttpServlet {
    private MaterialDAO materialDAO;
    private CommentDAO commentDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        materialDAO = new MaterialDAOImpl();
        commentDAO = new CommentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String materialIdString = request.getParameter("materialId");
        if (materialIdString != null && !materialIdString.isEmpty()) {
            UUID materialId = UUID.fromString(materialIdString);
            Material material = materialDAO.getMaterialById(materialId);

            if (material != null) {
                material.setUploaderName(materialDAO.getUploaderNameById(material.getUserId()));

                request.setAttribute("material", material);
                request.getRequestDispatcher("/material.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String materialIdString = request.getParameter("materialId");
        String commentText = request.getParameter("commentText");

        if (materialIdString != null && !materialIdString.isEmpty() && commentText != null) {
            UUID materialId = UUID.fromString(materialIdString);

            Comment comment = new Comment();
            comment.setMaterialId(materialId);
            comment.setText(commentText);
            comment.setCreationDate(new Date());

            commentDAO.addComment(comment);

            List<Comment> comments = materialDAO.getCommentsByMaterialId(materialId);

            StringBuilder htmlFragment = new StringBuilder();
            for (Comment c : comments) {
                htmlFragment.append("<p>").append(c.getText()).append("</p>");
            }

            response.setContentType("text/html");
            response.getWriter().write(htmlFragment.toString());
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

}