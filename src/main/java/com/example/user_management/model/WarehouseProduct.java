package com.example.user_management.model;

public class WarehouseProduct {
    private int id;
    private Product product;
    private Warehouse warehouse;

    public WarehouseProduct() {
    }

    public WarehouseProduct(int id, Product product, Warehouse warehouse) {
        this.id = id;
        this.product = product;
        this.warehouse = warehouse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
