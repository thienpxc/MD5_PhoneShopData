package com.example.md5_phoneshopdata.modules.product.product_ariant;

import com.example.md5_phoneshopdata.modules.product.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "ProductVariant")
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productVariant;
    private String color; // Màu sắc
    private String Image; // Ảnh
    private String storage; // Bộ nhớ
    private double price; // Giá
    private Integer quantity; // Số lượng
    private String description; // Mô tả
    private boolean status; // Trạng thái
}

