package com.example.md5_phoneshopdata.modules.product.admin.repository;

import com.example.md5_phoneshopdata.modules.product.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
