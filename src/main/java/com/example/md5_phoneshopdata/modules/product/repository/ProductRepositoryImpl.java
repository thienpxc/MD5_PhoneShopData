package com.example.md5_phoneshopdata.modules.product.repository;

import com.example.md5_phoneshopdata.modules.product.Product;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Repository
@Transactional
public class ProductRepositoryImpl implements IProductRepository{

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Product> findByStatus(boolean status) {
        return entityManager.createQuery("select p from Product p where p.status = :status", Product.class)
                .setParameter("status", status)
                .getResultList();
    }

    @Override
    public List<Product> findAll() {
        return  entityManager.createQuery("select p from Product p", Product.class)
                .getResultList() ;
    }

    @Override
    public Product findById(Long id) {
        return  entityManager.find(Product.class, id);
    }

    @Override
    public void save(Product product) {
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
    }

    @Override
    public void delete(Long id) {
        Product product = findById(id);
        if (product != null) {
            product.setStatus(false);
            entityManager.merge(product);
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        return entityManager.createQuery("select p from Product p where p.name like :name", Product.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

    @Override
    public boolean existsByName(String name) {
        return  entityManager.createQuery("select count(p) from Product p where p.name = :name", Long.class)
                .setParameter("name", name)
                .getSingleResult() > 0;
    }

    @Override
    public List<Product> findByPagination(int limit, int offset) {
        return entityManager.createQuery("select p from Product p", Product.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
