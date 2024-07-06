package com.example.md5_phoneshopdata.modules.product.admin.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantDTO {
    private Integer id;
    private String color;
    private Integer price;
    private String image;
    private Integer quantity;
    @Column(length = 10000)
    private String description;
}
