package org.example.util;

import org.example.model.UserPlatform;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/mainpage")
public class UserTypeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        UserPlatform user = (UserPlatform) httpRequest.getSession().getAttribute("user");

        if (user != null) {
            String userType = user.getUserType();

            if (userType.equals("Teacher")) {
                servletRequest.setAttribute("isTeacher", true);
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
