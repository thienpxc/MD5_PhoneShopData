package com.example.md5_phoneshopdata.modules.product.admin.service;



import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.product.admin.dto.*;

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
        variant.setProduct(product);
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
        variantImg.setProduct(product);
        variantImg.setImages(productVariantImgDTO.getImages());

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

        for (String imageUrl : dto.getImages()) {
            ProductVariantImgDTO imgDTO = new ProductVariantImgDTO(null, imageUrl);
            createProductVariantImg(product, imgDTO);
        }
        return product;
    }
    public Product editProductWithVariants(ProductWithVariantsImgDto dto) {
        if (dto.getProduct() == null) {
            throw new IllegalArgumentException("ProductDto cannot be null");
        }

        // Tìm sản phẩm hiện có
        Product product = productRepository.findById(dto.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Cập nhật thông tin sản phẩm
        updateProductInfo(product, dto.getProduct());

        // Xử lý biến thể
        handleProductVariants(product, dto.getVariants());

        // Xử lý ảnh
        handleProductImages(product, dto.getImages());

        return productRepository.save(product);
    }

    private void updateProductInfo(Product product, ProductDto productDto) {
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setStorage(productDto.getStorage());
        product.setCategory(categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found")));
    }

    private void handleProductVariants(Product product, List<ProductVariantDTO> variants) {
        productVariantRepository.deleteByProduct(product);
        for (ProductVariantDTO variantDTO : variants) {
            createProductVariant(product, variantDTO);
        }
    }

    private void handleProductImages(Product product, List<ImageDto> images) {
        productVariantRepositoryImg.deleteByProduct(product);
        for (ImageDto imageDto : images) {
            ProductVariantImgDTO imgDTO = new ProductVariantImgDTO(imageDto.getId(), imageDto.getImages());
            createProductVariantImg(product, imgDTO);
        }
    }
}
