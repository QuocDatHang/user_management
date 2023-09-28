package com.example.user_management.dao;

import com.example.user_management.model.Product;
import com.example.user_management.model.enumeration.ECategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DatabaseConnection {
    public List<Product> findAll() {
        var content = new ArrayList<Product>();
        var SELECT_ALL = "SELECT * FROM user_management.products;";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            var rs = preparedStatement.executeQuery();
            while (rs.next()) {
                content.add(getProductByResultSet(rs));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return content;
    }

    private Product getProductByResultSet(ResultSet rs) throws SQLException {
        var product = new Product();
        product.setId(rs.getInt("id"));
        product.setProductName(rs.getString("name"));
        product.setPrice(rs.getBigDecimal("price"));
        product.setCategory(ECategory.valueOf(rs.getString("category")));
        return product;
    }
}
