package com.example.md5_phoneshopdata.controller;


import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.product.ProductRepository;
import com.example.md5_phoneshopdata.modules.product.service.IProductSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductSerive productService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }
    @GetMapping("/products/active")
    public List<Product> getActiveProducts() {
        return productRepository.findByStatus(true);
    }

    @GetMapping("/products/inactive")
    public List<Product> getInactiveProducts() {
        return productRepository.findByStatus(false);
    }

}
