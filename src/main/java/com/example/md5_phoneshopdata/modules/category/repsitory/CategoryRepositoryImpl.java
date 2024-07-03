package com.example.md5_phoneshopdata.modules.category.repsitory;

import com.example.md5_phoneshopdata.modules.category.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
@Transactional
public class CategoryRepositoryImpl  implements CategoryRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("select c from Category c", Category.class)
                .getResultList();
    }

    @Override
    public List<Category> findByStatus(Boolean status) {
        return entityManager.createQuery("select c from Category c where c.status = :status", Category.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<Category> searchByName(String name) {
        return entityManager.createQuery("select c from Category c where c.name like :name", Category.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    public Category findById(Integer id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    public void save(Category category) {
        if (category.getId() == null) {
            entityManager.persist(category);
        } else {
            entityManager.merge(category);
        }
    }

    @Override
    public void delete(Integer id) {
        Category category = findById(id);
        if (category != null) {
            category.setStatus(false);
            entityManager.merge(category);
        }
    }

    @Override
    public boolean existsByName(String name) {
        return entityManager.createQuery("select count(c) > 0 from Category c where c.name = :name", Boolean.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Category> findByPagination(int limit, int offset) {
        return entityManager.createQuery("select c from Category c", Category.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }



}
