package org.example.servlets;

import org.example.DAO.ProfileDAO;
import org.example.DAO.ProfileDAOImpl;
import org.example.DAO.UserPlatformDAO;
import org.example.DAO.UserPlatformDAOImpl;
import org.example.model.Profile;
import org.example.model.UserPlatform;
import org.example.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private final UserPlatformDAO userPlatformDAO = new UserPlatformDAOImpl();
    private final ProfileDAO profileDAO = new ProfileDAOImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        String hashedPassword = hashPassword(password);

        UUID userId = UUID.randomUUID();

        UserPlatform user = new UserPlatform();
        user.setUserId(userId);
        user.setLogin(login);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(hashedPassword);
        user.setUserType(userType);

        userPlatformDAO.addUser(user);

        Profile profile = new Profile();
        profile.setProfileId(UUID.randomUUID());
        profile.setUserId(user.getUserId());
        profile.setBio(null);

        profileDAO.addProfile(profile);

        response.sendRedirect("login.jsp");
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}