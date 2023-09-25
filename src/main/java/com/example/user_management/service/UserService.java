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
    public List<User> getAllUsers(boolean isdeleted){
        return userDAO.findAll(isdeleted);
    }
    public void create(User user){
        userDAO.create(user);
    }
    public void update(User user, int id){
        userDAO.update(user, id);
    }
    public void delete(int id){
        userDAO.delete(id);
    }
    public void restore(int id){
        userDAO.restore(id);
    }
    public User findById(int id){
        return userDAO.findById(id);
    }
}
