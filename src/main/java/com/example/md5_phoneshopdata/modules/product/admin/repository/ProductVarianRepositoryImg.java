package com.example.md5_phoneshopdata.modules.product.admin.repository;

import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.product.user.product_ariant.ProductVariantImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVarianRepositoryImg extends JpaRepository<ProductVariantImg, Integer> {
    void deleteByProduct(Product product);
}
