package com.example.user_management.service;

import com.example.user_management.dao.ProductImportDAO;
import com.example.user_management.model.ProductImport;
import com.example.user_management.service.dto.ProductImportListResponse;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class ProductImportService {
    private ProductImportDAO productImportDAO;
    public ProductImportService(){
        productImportDAO = new ProductImportDAO();
    }
    public List<ProductImportListResponse> findAll(){
        return productImportDAO.findAll();
    }
    public void create(HttpServletRequest req){
        String code = req.getParameter("code");
        Date importDate = Date.valueOf(req.getParameter("importDate"));
        BigDecimal totalPrice = BigDecimal.ZERO;

        ProductImport productImport = new ProductImport();
        productImport.setCode(code);
        productImport.setImportDate(importDate);
        productImport.setTotalPrice(totalPrice);

        productImportDAO.create(productImport);
    }
}
//    private int id;
//    private String code;
//    private Date importDate;
//    private BigDecimal totalPrice;