package com.example.user_management.service;

import com.example.user_management.dao.UserDAO;
import com.example.user_management.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;
    public UserService(){
        userDAO = new UserDAO();
    }
    public List<User> getAllUsers(){
        return userDAO.findAll();
    }
    public void create(User user){
        userDAO.create(user);
    }
    public void update(User user){

    }
    public User findById(int id){
        return userDAO.findById(id);
    }
}
