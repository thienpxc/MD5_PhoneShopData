package com.example.md5_phoneshopdata.modules.product.admin.repository;

import com.example.md5_phoneshopdata.modules.product.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findByStatus(boolean status);

    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void delete(Long id);

    List<Product> searchByName(String name);

    boolean existsByName(String name);

    List<Product> findByPagination(int limit, int offset);


}
