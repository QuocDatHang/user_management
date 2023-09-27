package com.example.user_management.service.dto;

import com.example.user_management.model.Product;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class ProductImportListResponse {
    private int id;
    private String code;
    private Date importDate;
    private String products;
    private BigDecimal totalPrice;

    public ProductImportListResponse(int id, String code, Date importDate, String products, BigDecimal totalPrice) {
        this.id = id;
        this.code = code;
        this.importDate = importDate;
        this.products = products;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
