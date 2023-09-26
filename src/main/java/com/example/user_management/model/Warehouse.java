package com.example.user_management.model;

import java.util.Date;
import java.util.List;

public class Warehouse {
    private int id;
    private String wh_name;
    private List<Product> productList;
    private Date createAt;

    public Warehouse() {
    }

    public Warehouse(int id, String wh_name, List<Product> productList, Date createAt) {
        this.id = id;
        this.wh_name = wh_name;
        this.productList = productList;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWh_name() {
        return wh_name;
    }

    public void setWh_name(String wh_name) {
        this.wh_name = wh_name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
