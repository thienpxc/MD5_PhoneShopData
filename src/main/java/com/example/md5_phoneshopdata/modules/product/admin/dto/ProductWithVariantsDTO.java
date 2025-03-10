package com.example.md5_phoneshopdata.modules.product.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithVariantsDTO {
    private ProductDto product;
    private List<ProductVariantDTO> variants;
    private List<String> images;

}
