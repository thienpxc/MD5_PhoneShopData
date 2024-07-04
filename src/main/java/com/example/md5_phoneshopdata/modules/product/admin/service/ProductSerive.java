package com.example.md5_phoneshopdata.modules.product.admin.service;

import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.product.admin.repository.IProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductSerive implements IProductSerive {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByStatus(boolean status) {
        return productRepository.findByStatus(status);
    }

    @Override
    public List<Product> searchByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p where p.name like :name", Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

    @Override
    public List<Product> findByPagination(int limit, int offset) {
        return productRepository.findByPagination(limit, offset);
    }
  }
