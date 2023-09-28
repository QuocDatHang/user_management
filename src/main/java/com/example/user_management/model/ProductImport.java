package com.example.user_management.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class ProductImport {
    private int id;
    private String code;
    private java.sql.Date importDate;
    private BigDecimal totalPrice;
    private List<ProductImportDetail> productImportDetails;

    public ProductImport() {
    }

    public ProductImport(int id, String code, java.sql.Date importDate, BigDecimal totalPrice) {
        this.id = id;
        this.code = code;
        this.importDate = importDate;
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

    public java.sql.Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setimportDate(Date importDate) {
        this.importDate = importDate;
    }
}
