package com.example.md5_phoneshopdata.modules.product.admin.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private Integer id;
    private String name;
    @Column(length = 10000)
    private String description;
    private String storage;
    private List<ProductVariantDTO> variants;
    private List<String> images;
    private Integer categoryId;
}
