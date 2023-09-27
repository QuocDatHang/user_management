package com.example.user_management.service;

import com.example.user_management.dao.ProductImportDAO;
import com.example.user_management.service.dto.ProductImportListResponse;

import java.util.List;

public class ProductImportService {
    private ProductImportDAO productImportDAO;
    public ProductImportService(){
        productImportDAO = new ProductImportDAO();
    }
    public List<ProductImportListResponse> findAll(){
        return productImportDAO.findAll();
    }
}
