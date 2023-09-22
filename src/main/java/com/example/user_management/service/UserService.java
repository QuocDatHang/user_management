package com.example.user_management.service;

import com.example.user_management.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final static List<User> userList;
    static{
        userList = new ArrayList<>();
    }
    public List<User> getAllUsers(){
        return userList;
    }
    public void create(User user){

    }
    public void update(User user){

    }
    public User findById(int id){
        return userList.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }
}
