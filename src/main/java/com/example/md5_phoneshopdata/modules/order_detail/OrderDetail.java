package com.example.md5_phoneshopdata.modules.order_detail;

import jakarta.persistence.*;
import lombok.*;
import com.example.md5_phoneshopdata.modules.order.Orders;
import com.example.md5_phoneshopdata.modules.product.Product;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String productName;
    private double price;
    private int quantity;
}
