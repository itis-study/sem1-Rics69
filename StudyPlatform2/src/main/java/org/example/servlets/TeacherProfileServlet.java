package org.example.servlets;

import org.example.DAO.ProfileDAO;
import org.example.DAO.ProfileDAOImpl;
import org.example.DAO.UserPlatformDAO;
import org.example.DAO.UserPlatformDAOImpl;
import org.example.model.Profile;
import org.example.model.UserPlatform;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/teacher_profile")
public class TeacherProfileServlet extends HttpServlet {
    private UserPlatformDAO userPlatformDAO;
    private ProfileDAO profileDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        userPlatformDAO = new UserPlatformDAOImpl();
        profileDAO = new ProfileDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdParam = req.getParameter("userId");
        if (userIdParam != null) {
            UUID userId = UUID.fromString(userIdParam);
            UserPlatform teacher = userPlatformDAO.getUserById(userId);
            Profile teacherProfile = profileDAO.getProfileByUserId(userId);

            req.setAttribute("teacher", teacher);
            req.setAttribute("teacherProfile", teacherProfile);

            req.getRequestDispatcher("teacher_profile.jsp").forward(req, resp);
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
