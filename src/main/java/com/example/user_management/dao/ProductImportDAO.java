package com.example.user_management.dao;

import com.example.user_management.service.dto.ProductImportListResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImportDAO extends DatabaseConnection {
    public List<ProductImportListResponse> findAll() {
        var result = new ArrayList<ProductImportListResponse>();
        String SELECT_ALL = "SELECT pi.*, group_concat(p.productName) AS products FROM product_imports pi " +
                "JOIN product_import_details pid ON pi.id = pid.product_import_id " +
                "JOIN products p ON p.id = pid.product_id GROUP BY (pi.id)";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                var productImportListResponse = new ProductImportListResponse(rs.getInt("id"), rs.getString("code"),
                        rs.getDate("importDate"), rs.getString("products"), rs.getBigDecimal("totalPrice"));
                result.add(productImportListResponse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
