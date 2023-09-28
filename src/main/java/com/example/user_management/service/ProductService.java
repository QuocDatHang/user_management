package com.example.user_management.service;

import com.example.user_management.dao.ProductDAO;
import com.example.user_management.model.Product;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();
    public List<Product> getAllProduct(){
        return productDAO.findAll();
    }
    public void create(){

    }
    public Product findById(int id){

        return new Product();
    }
}
