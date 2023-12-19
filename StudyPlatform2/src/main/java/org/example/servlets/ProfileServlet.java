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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
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
        HttpSession session = req.getSession();
        UserPlatform user = (UserPlatform) session.getAttribute("user");
        log(String.valueOf(user.getUserId()));
        Profile profile = profileDAO.getProfileByUserId(user.getUserId());

        req.setAttribute("user", user);
        req.setAttribute("profile", profile);

        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }
}
