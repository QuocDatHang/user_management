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
import java.util.List;

@WebServlet(name = "userController", value = "/user")
public class UserController extends HttpServlet {
    private UserService userService;
    private RoleService roleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" -> showCreate(req, resp);
            case "edit" -> showEdit(req, resp);
            case "showRestore" -> showRestore(req, resp);
            case "delete" -> delete(req, resp);
            default -> showUsers(req, resp);
        }
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("editUser", userService.findById(Integer.parseInt(req.getParameter("id"))));
        req.setAttribute("roles", roleService.getAllRoles());
        req.setAttribute("genders", EGender.values());
        req.setAttribute("message", req.getParameter("message"));
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        userService.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/user?message=Delete Successful!");
    }

    private void showRestore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userService.getAllUsers(true));
        req.getRequestDispatcher("restore.jsp").forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", roleService.getAllRoles());
        req.setAttribute("genders", EGender.values());
        req.setAttribute("message", req.getParameter("message"));
        req.getRequestDispatcher("create.jsp").forward(req, resp);
    }

    private void showUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userService.getAllUsers(false));
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" -> create(req, resp);
            case "edit" -> edit(req, resp);
            case "restore" -> restore(req, resp);
            default -> showUsers(req, resp);
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();
        user.setLastName(req.getParameter("lastName"));
        user.setFirstName(req.getParameter("firstName"));
        user.setUserName(req.getParameter("userName"));
        user.setDob(Date.valueOf(req.getParameter("dob")));
        user.setEmail(req.getParameter("email"));
        user.setRole(roleService.findById(Integer.parseInt(req.getParameter("role"))));
        user.setGender(EGender.valueOf(req.getParameter("gender")));

        userService.update(user);
        resp.sendRedirect("/user?message=Edit Successful!");
    }

    private void restore(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] ids = req.getParameterValues("checkbox");
        for (String id : ids){
            userService.restore(Integer.parseInt(id));
        }
        resp.sendRedirect("/user?action=showRestore&message=Restore Successful!");
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User();
        user.setLastName(req.getParameter("lastName"));
        user.setFirstName(req.getParameter("firstName"));
        user.setUserName(req.getParameter("userName"));
        user.setDob(Date.valueOf(req.getParameter("dob")));
        user.setEmail(req.getParameter("email"));
        user.setRole(roleService.findById(Integer.parseInt(req.getParameter("role"))));
        user.setGender(EGender.valueOf(req.getParameter("gender")));

        userService.create(user);
        resp.sendRedirect("/user?message=Create Successful!");
    }

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        roleService = new RoleService();
    }
}
