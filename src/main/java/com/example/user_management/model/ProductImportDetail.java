package com.example.user_management.model;

import java.math.BigDecimal;

public class ProductImportDetail {
    private int id;
    private int quantity;
    private BigDecimal importPrice;
    private Product product;
    private ProductImport productImport;

    public ProductImportDetail() {
    }

    public ProductImportDetail(int id, int quantity, BigDecimal importPrice, Product product, ProductImport productImport) {
        this.id = id;
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.product = product;
        this.productImport = productImport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getimportPrice() {
        return importPrice;
    }

    public void setimportPrice(BigDecimal importPrice) {
        this.importPrice = importPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductImport getProductImport() {
        return productImport;
    }

    public void setProductImport(ProductImport productImport) {
        this.productImport = productImport;
    }
}
