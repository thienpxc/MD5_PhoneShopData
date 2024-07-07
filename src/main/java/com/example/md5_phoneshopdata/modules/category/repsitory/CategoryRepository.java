package com.example.md5_phoneshopdata.modules.category.repsitory;

import com.example.md5_phoneshopdata.modules.category.Category;
import com.example.md5_phoneshopdata.modules.product.Product;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void delete(Integer id);

    List<Category> searchByName(String name);

    List<Category> findByStatus(Boolean status);

    boolean existsByName(String name);

    List<Category> findByPagination(int limit, int offset);

    List<Product> findProductsByCategoryId(Integer categoryId);



}
