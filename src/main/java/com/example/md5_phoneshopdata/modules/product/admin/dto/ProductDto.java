package com.example.md5_phoneshopdata.modules.product.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private String images;
    private String storage;
    private Integer categoryId;
}
