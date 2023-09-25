package com.example.user_management.dao;

import com.example.user_management.model.EGender;
import com.example.user_management.model.Role;
import com.example.user_management.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DatabaseConnection {
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        String SELECT_ALL_USER = "SELECT u.*, r.name roleName FROM users u JOIN roles r on u.role_id = r.id";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLastName(rs.getString("lastName"));
                user.setFirstName(rs.getString("firstName"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setDob(rs.getDate("dob"));
                user.setRole(new Role(rs.getInt("role_id"), rs.getString("roleName")));
                user.setGender(EGender.valueOf(rs.getString("gender")));
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public User findById(int id) {
        String FIND_BY_ID = "SELECT u.*, r.name roleName FROM users u JOIN roles r on u.role_id = r.id HAVING u.id = ?";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setLastName(rs.getString("lastName"));
                user.setFirstName(rs.getString("firstName"));
                user.setUserName(rs.getString("userName"));
                user.setEmail(rs.getString("email"));
                user.setDob(rs.getDate("dob"));
                user.setRole(new Role(rs.getInt("role_id"), rs.getString("roleName")));
                user.setGender(EGender.valueOf(rs.getString("gender")));
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void create(User user){
        String CREATE_USER = "INSERT INTO users (`lastName`, `firstName`, `userName`, `email`, `dob`, `role_id`, `gender`) " +
                                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);

            preparedStatement.setString(1, user.getLastName());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setDate(5, (Date) user.getDob());
            preparedStatement.setInt(6, user.getRole().getId());
            preparedStatement.setString(7, user.getGender().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}
