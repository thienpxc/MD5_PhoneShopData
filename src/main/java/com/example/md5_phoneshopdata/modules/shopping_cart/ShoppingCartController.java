package com.example.md5_phoneshopdata.modules.shopping_cart;

import com.example.md5_phoneshopdata.modules.shopping_cart.sevice.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class ShoppingCartController {
    @Autowired
    private CartService cartService;


    @GetMapping("/{userId}")
    public ResponseEntity<List<ShoppingCart>> getActiveCart(@PathVariable Integer userId) {
        List<ShoppingCart> activeCart = cartService.getActiveCart(userId);
        return ResponseEntity.ok(activeCart);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody ShoppingCart cart) {
        try {
            System.out.println("cart = " + cart);
            List<ShoppingCart> savedCart = cartService.addToCart(cart);
            return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error adding to cart: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
