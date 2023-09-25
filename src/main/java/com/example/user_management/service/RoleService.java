package com.example.user_management.service;

import com.example.user_management.dao.RoleDAO;
import com.example.user_management.model.Role;

import java.util.List;

public class RoleService {
    private RoleDAO roleDAO;

    public RoleService() {
        roleDAO = new RoleDAO();
    }
    public List<Role> getAllRoles(){
        return roleDAO.findAllRoles();
    }
    public Role findById(int id){
       return roleDAO.findById(id);
    }

}
