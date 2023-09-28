package com.example.user_management.service;

import com.example.user_management.dao.ProductImportDAO;
import com.example.user_management.model.ProductImport;
import com.example.user_management.model.ProductImportDetail;
import com.example.user_management.service.dto.ProductImportListResponse;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
        // totalPrice = quantities * inputPrice;
        List<Integer> quantities = Arrays.stream(req.getParameterValues("quantities")).map(Integer::parseInt).collect(Collectors.toList());
        List<BigDecimal> importPrices = Arrays.stream(req.getParameterValues("importPrice")).map(BigDecimal::new).collect(Collectors.toList());
        List<Integer> productIds = Arrays.stream(req.getParameterValues("productIds")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < quantities.size(); i++) {
            totalPrice = totalPrice.add(BigDecimal.valueOf(quantities.get(i)).multiply(importPrices.get(i)));
        }

        ProductImport productImport = new ProductImport(0, code, importDate, totalPrice);
        productImport.setId(productImportDAO.create(productImport));


        for (int i = 0; i < quantities.size(); i++) {
            productImportDAO.createProductImportDetail(quantities.get(i), importPrices.get(i), productIds.get(i), productImport.getId());
        }
    }
}
//    private int id;
//    private String code;
//    private Date importDate;
//    private BigDecimal totalPrice;

//    private int id;
//    private int quantity;
//    private BigDecimal importPrice;
//    private Product product;
//    private ProductImport productImport;