package org.example.servlets;

import org.example.DAO.UserPlatformDAO;
import org.example.DAO.UserPlatformDAOImpl;
import org.example.model.UserPlatform;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserPlatformDAO userPlatformDAO = new UserPlatformDAOImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String plainPassword = request.getParameter("password");

        String hashedPassword = hashPassword(plainPassword);

        UserPlatform user = userPlatformDAO.getUserByLogin(login);

        if (user != null && hashedPassword.equals(user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("mainpage");
        } else {
            response.sendRedirect("login");
        }
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
