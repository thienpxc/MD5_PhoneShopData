package com.example.md5_phoneshopdata.modules.product.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductWithVariantsDTO {
    private ProductDto product;
    private List<ProductVariantDTO> variants;
//    private List<ProductVariantImgDTO> images;

}
