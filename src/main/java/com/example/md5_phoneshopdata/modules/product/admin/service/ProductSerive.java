package com.example.md5_phoneshopdata.modules.product.admin.service;



import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.product.admin.dto.ProductDto;
import com.example.md5_phoneshopdata.modules.product.admin.dto.ProductVariantDTO;
import com.example.md5_phoneshopdata.modules.product.admin.dto.ProductVariantImgDTO;
import com.example.md5_phoneshopdata.modules.product.admin.dto.ProductWithVariantsDTO;

import com.example.md5_phoneshopdata.modules.product.admin.repository.CategoryRepositoryProductImpl;
import com.example.md5_phoneshopdata.modules.product.admin.repository.ProductRepository;
import com.example.md5_phoneshopdata.modules.product.admin.repository.ProductVarianRepositoryImg;
import com.example.md5_phoneshopdata.modules.product.admin.repository.ProductVariantRepository;
import com.example.md5_phoneshopdata.modules.product.user.product_ariant.ProductVariant;
import com.example.md5_phoneshopdata.modules.product.user.product_ariant.ProductVariantImg;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service
public  class ProductSerive {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepositoryProductImpl categoryRepository;

    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Autowired
    private ProductVarianRepositoryImg productVariantRepositoryImg;

    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setImages(productDto.getImages());
        product.setDescription(productDto.getDescription());
        product.setStorage(productDto.getStorage());
        product.setCategory(categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found")));
        product.setCreateDate(LocalDate.now().toString());
        product.setStatus(true);

        return productRepository.save(product);
    }
    public ProductVariant createProductVariant(Product product, ProductVariantDTO variantDTO) {
        ProductVariant variant = new ProductVariant();
        variant.setProductVariant(product);
        variant.setColor(variantDTO.getColor());
        variant.setPrice(variantDTO.getPrice());
        variant.setImage(variantDTO.getImage());
        variant.setQuantity(variantDTO.getQuantity());
        variant.setDescription(variantDTO.getDescription());
        variant.setStatus(true);

        return productVariantRepository.save(variant);
    }
    public ProductVariantImg createProductVariantImg(Product product, ProductVariantImgDTO productVariantImgDTO) {
        ProductVariantImg variantImg = new ProductVariantImg();
        variantImg.setProductVariantImg(product);
        variantImg.setImage(productVariantImgDTO.getImages());

        return productVariantRepositoryImg.save(variantImg);
    }
    public Product createProductWithVariants(ProductWithVariantsDTO dto) {
        if (dto.getProduct() == null) {
            throw new IllegalArgumentException("ProductDto cannot be null");
        }
        Product product = createProduct(dto.getProduct());

        for (ProductVariantDTO variantDTO : dto.getVariants()) {
            createProductVariant(product, variantDTO);
        }

        // Add this loop to create ProductVariantImg for each ProductVariantImgDTO
//        for (ProductVariantImgDTO imgDTO : dto.getImages()) {
//            createProductVariantImg(product, imgDTO);
//        }

        return product;
    }
}
