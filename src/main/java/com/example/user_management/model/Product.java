package com.example.user_management.model;

import com.example.user_management.model.enumeration.ECategory;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String productName;
    private BigDecimal price;
    private ECategory category;

    public Product() {
    }

    public Product(int id, String productName, BigDecimal price, ECategory category) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }
}
