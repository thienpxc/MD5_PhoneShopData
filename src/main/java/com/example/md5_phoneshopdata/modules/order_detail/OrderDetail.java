package com.example.md5_phoneshopdata.modules.order_detail;

import com.example.md5_phoneshopdata.modules.order.Orders;
import com.example.md5_phoneshopdata.modules.product.Product;
import jakarta.persistence.*;
import lombok.*;


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

    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    private String productName;
    private double price;
    private int quantity;
}
