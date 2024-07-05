package com.example.md5_phoneshopdata.modules.product.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductVariantDTO {
    private Integer id;
    private String color;
    private Integer price;
    private String image;
    private Integer quantity;
    private String description;
}
