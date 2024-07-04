package com.example.md5_phoneshopdata.modules.product.user.productDao;

import com.example.md5_phoneshopdata.modules.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface IProductUserDao extends JpaRepository<Product, Integer>{
    Product findAll(boolean b);


}
