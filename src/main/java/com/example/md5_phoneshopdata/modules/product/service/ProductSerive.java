package com.example.md5_phoneshopdata.modules.product.service;

import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.product.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductSerive implements IProductSerive {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product where status = true ", Product.class);
        return query.getResultList();
    }

    public List<Product> findByStatus(boolean status) {
        return productRepository.findByStatus(status);
    }

    @Override
    public Object findById(Object id) {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void delete(Object id) {

    }
}
