package com.example.md5_phoneshopdata.modules.product.admin.repository;

import com.example.md5_phoneshopdata.modules.product.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
