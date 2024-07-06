package com.example.md5_phoneshopdata.modules.shopping_cart.sevice;

import com.example.md5_phoneshopdata.modules.product.admin.repository.ProductVariantRepository;
import com.example.md5_phoneshopdata.modules.product.user.product_ariant.ProductVariant;
import com.example.md5_phoneshopdata.modules.shopping_cart.ShoppingCart;
import com.example.md5_phoneshopdata.modules.shopping_cart.repository.CartRepository;
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
            for (ShoppingCart existingCart : existingCarts) {
                existingCart.setQuantity(existingCart.getQuantity() + 1);
                cartRepository.save(existingCart);
            }
        } else {
            cart.setQuantity(1);
            cartRepository.save(cart);
            existingCarts.add(cart);
        }

        return existingCarts;
    }
}
