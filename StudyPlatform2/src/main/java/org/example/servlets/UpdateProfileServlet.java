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

@WebServlet("/updateUserProfile")
public class UpdateProfileServlet extends HttpServlet {
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
        req.getRequestDispatcher("updateUserProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserPlatform user = (UserPlatform) session.getAttribute("user");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        user.setFirstName(firstName);
        user.setLastName(lastName);
        userPlatformDAO.updateUser(user);

        Profile profile = profileDAO.getProfileByUserId(user.getUserId());
        profile.setBio(request.getParameter("bio"));
        profileDAO.updateProfile(profile);

        session.setAttribute("user", user);

        response.sendRedirect("profile");
    }
}
