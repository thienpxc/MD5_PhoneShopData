package com.example.md5_phoneshopdata.modules.shopping_cart;

import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.users.Users;
import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private int quantity;

}
