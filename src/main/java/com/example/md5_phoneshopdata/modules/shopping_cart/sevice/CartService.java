package com.example.md5_phoneshopdata.modules.shopping_cart.sevice;

import com.example.md5_phoneshopdata.modules.product.admin.repository.ProductVariantRepository;
import com.example.md5_phoneshopdata.modules.product.user.product_ariant.ProductVariant;
import com.example.md5_phoneshopdata.modules.shopping_cart.ShoppingCart;
import com.example.md5_phoneshopdata.modules.shopping_cart.repository.CartRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductVariantRepository productVariantRepository;

    public List<ShoppingCart> addToCart(ShoppingCart cart) {
        List<ShoppingCart> existingCarts = cartRepository.findByUser_IdAndProduct_IdAndProductVariant_Id(
                cart.getUser().getId(),
                cart.getProduct().getId(),
                cart.getProductVariant().getId()
        );

        if (!existingCarts.isEmpty()) {
            boolean updated = false;
            for (ShoppingCart existingCart : existingCarts) {
                if (existingCart.isStatus() == cart.isStatus()) {
                    existingCart.setQuantity(existingCart.getQuantity() + cart.getQuantity());
                    cartRepository.save(existingCart);
                    updated = true;
                    break;
                }
            }
            if (!updated) {
                cartRepository.save(cart);
                existingCarts.add(cart);
            }
        } else {
            cartRepository.save(cart);
            existingCarts.add(cart);
        }

        return existingCarts;
    }
    public List<ShoppingCart> getActiveCart(Integer userId) {
        return cartRepository.findByUser_IdAndStatusTrue(userId);
    }
}
