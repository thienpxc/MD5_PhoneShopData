package com.example.md5_phoneshopdata.modules.shopping_cart.repository;

import com.example.md5_phoneshopdata.modules.shopping_cart.ShoppingCart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@Repository
public interface CartRepository extends JpaRepository<ShoppingCart, Integer> {
    List<ShoppingCart> findByUser_IdAndStatusTrue(Integer user);
List<ShoppingCart> findByUser_IdAndProduct_IdAndProductVariant_Id(Integer user, Integer product, Integer productVariant);
}
