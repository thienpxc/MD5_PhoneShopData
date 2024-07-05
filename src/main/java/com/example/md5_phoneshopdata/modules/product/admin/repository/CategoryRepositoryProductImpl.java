package com.example.md5_phoneshopdata.modules.product.admin.repository;

import com.example.md5_phoneshopdata.modules.category.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CategoryRepositoryProductImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Category> findById(Integer id) {
        Category category = entityManager.find(Category.class, id);
        if (category == null) {
            throw new RuntimeException("Category not found");
        }
        return Optional.of(category);
    }
}
