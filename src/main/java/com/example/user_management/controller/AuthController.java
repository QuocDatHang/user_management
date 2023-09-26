package com.example.user_management.controller;

import com.example.user_management.model.EGender;
import com.example.user_management.model.User;
import com.example.user_management.service.RoleService;
import com.example.user_management.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "loginController", value = "/auth")
public class AuthController extends HttpServlet {
    private UserService userService;
    private RoleService roleService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "showRegister" -> showRegister(req, resp);
            default -> showLogin(req, resp);
        }
    }

    private void showRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", roleService.getAllRoles());
        req.setAttribute("genders", EGender.values());
        req.setAttribute("message", req.getParameter("message"));
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    private void showLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", req.getParameter("message"));
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "register" -> register(req, resp);
            default -> login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        req.setAttribute("us", req.getParameter("userName"));
//        req.setAttribute("pass", req.getParameter("password"));
//        req.getRequestDispatcher("login.jsp").forward(req, resp);
        boolean checkLogin = userService.login(req, resp);
        if (!checkLogin){
            resp.sendRedirect("/auth?message=Username or password not correct");
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        userService.create(getUserByRequest(req));
        resp.sendRedirect("/auth?message=Register Successful!");
    }
    public User getUserByRequest(HttpServletRequest req){
        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));
        user.setLastName(req.getParameter("lastName"));
        user.setFirstName(req.getParameter("firstName"));
        user.setDob(Date.valueOf(req.getParameter("dob")));
        user.setEmail(req.getParameter("email"));
        user.setRole(roleService.findById(Integer.parseInt(req.getParameter("role"))));
        user.setGender(EGender.valueOf(req.getParameter("gender")));
        return user;
    }
    @Override
    public void init() throws ServletException {
        userService = new UserService();
        roleService = new RoleService();
    }
}
