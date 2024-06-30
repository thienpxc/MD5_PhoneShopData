package com.example.md5_phoneshopdata.modules.product.service;

import com.example.md5_phoneshopdata.modules.product.Product;
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

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product where isDeleted = true ", Product.class);
        return query.getResultList();
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
