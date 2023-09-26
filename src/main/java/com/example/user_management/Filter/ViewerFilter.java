package com.example.user_management.Filter;

import com.example.user_management.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/index.jsp/*")
public class ViewerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            ((HttpServletResponse) response).sendRedirect("auth");
            return;
        }
        if (user.getRole().getName().equals("Viewer")) {
            ((HttpServletResponse) response).sendRedirect("auth");
            return;
        }
        chain.doFilter(request, response);
    }
}
