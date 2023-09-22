package com.example.user_management.service;

import com.example.user_management.model.Roles;

import java.util.ArrayList;
import java.util.List;

public class RolesService {
    private static List<Roles> roles;
    static {
        roles = new ArrayList<>();
        roles.add(new Roles(1,"user"));
        roles.add(new Roles(2,"admin"));
        }
    }
