package com.example.user_management.dao;

import com.example.user_management.model.ProductImport;
import com.example.user_management.service.dto.ProductImportListResponse;

import java.math.BigDecimal;
import java.sql.*;
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

    public int create(ProductImport productImport){
        String CREATE_PRODUCT_IMPORT = "INSERT INTO `product_imports` (`code`, `importDate`, `totalPrice`) VALUES (?, ?, ?)";
        String MAX_ID = "SELECT MAX(id) as maxId FROM product_imports";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT_IMPORT);
            preparedStatement.setString(1, productImport.getCode());
            preparedStatement.setDate(2, productImport.getImportDate());
            preparedStatement.setBigDecimal(3, productImport.getTotalPrice());
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement(MAX_ID);
            ResultSet rs = preparedStatement1.executeQuery();
            while (rs.next()){
                return rs.getInt("maxId");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    //    private int quantity;
//    private BigDecimal importPrice;
//    private Product product;
//    private ProductImport productImport;
    public void createProductImportDetail(int quantity, BigDecimal importPrice, int productId, int productImportId){
        String CREATE_PRODUCT_IMPORT_DETAIL = "INSERT INTO `product_import_details` (`quantity`, `inputPrice`, `product_id`, `product_import_id`) " +
                                                "VALUES (?, ?, ?, ?)";
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT_IMPORT_DETAIL);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setBigDecimal(2, importPrice);
            preparedStatement.setInt(3, productId);
            preparedStatement.setInt(4, productImportId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
