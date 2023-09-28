package com.example.user_management.controller;

import com.example.user_management.service.ProductImportService;
import com.example.user_management.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name ="ProductImportController", urlPatterns = "/productImport")
public class ProductImportController extends HttpServlet {
    private ProductImportService productImportService;
    private ProductService productService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "showCreate" -> showCreate(req, resp);
            default -> showList(req, resp);
        }
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("products", productService.getAllProduct());
        req.setAttribute("productsJSON", new ObjectMapper().writeValueAsString(productService.getAllProduct()));
        req.getRequestDispatcher("/productImport/create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productImports", productImportService.findAll());
        req.getRequestDispatcher("productImport/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        productImportService = new ProductImportService();
        productService = new ProductService();
    }
}
