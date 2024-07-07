package com.example.md5_phoneshopdata.modules.category.service;

import com.example.md5_phoneshopdata.modules.category.Category;
import com.example.md5_phoneshopdata.modules.category.repsitory.CategoryRepository;
import com.example.md5_phoneshopdata.modules.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findByStatus(Boolean status) {
        return categoryRepository.findByStatus(status);
    }

    @Override
    public List<Category> searchByName(String name) {
        return categoryRepository.searchByName(name);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.delete(id);
    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

    @Override
    public List<Category> findByPagination(int limit, int offset) {
        return categoryRepository.findByPagination(limit, offset);
    }

    @Override
    public List<Product> findProductsByCategoryId(Integer categoryId) {
        return categoryRepository.findProductsByCategoryId(categoryId);
    }





}
