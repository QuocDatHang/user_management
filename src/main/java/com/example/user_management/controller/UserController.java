package com.example.user_management.controller;

import com.example.user_management.service.RolesService;
import com.example.user_management.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name ="userController", value = "/user")
public class UserController extends HttpServlet {
    private UserService userService;
    private RolesService rolesService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "showUsers" -> showUsers();
            case "create" -> showCreate();
        }
    }

    private void showCreate() {

    }

    private void showUsers() {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        userService = new UserService();
        rolesService = new RolesService();
    }
}
