package com.example.md5_phoneshopdata.controller;


import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.product.repository.IProductRepository;
import com.example.md5_phoneshopdata.modules.product.service.IProductSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")

public class ProductController {

    @Autowired
    private IProductSerive productService;
    @Autowired
    private IProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productService.findByStatus(true);

    }



    @PostMapping("/product/add")
    public void addProduct(Product product) {
        productService.save(product);
    }



//    @GetMapping("/products/active")
//    public List<Product> getActiveProducts() {
//        return productRepository.findByStatus(true);
//    }
//
//    @GetMapping("/products/inactive")
//    public List<Product> getInactiveProducts() {
//        return productRepository.findByStatus(false);
//    }

}
