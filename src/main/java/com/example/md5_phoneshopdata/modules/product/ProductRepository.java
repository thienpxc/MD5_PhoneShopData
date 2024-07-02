package com.example.md5_phoneshopdata.modules.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findByStatus(boolean status);
}
