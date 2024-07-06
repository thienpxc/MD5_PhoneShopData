package com.example.md5_phoneshopdata.modules.product.admin;



import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.product.admin.dto.ProductWithVariantsDTO;
import com.example.md5_phoneshopdata.modules.product.admin.dto.ProductWithVariantsImgDto;
import com.example.md5_phoneshopdata.modules.product.admin.repository.ProductRepository;
import com.example.md5_phoneshopdata.modules.product.admin.service.ProductSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/admin")
@CrossOrigin("*")

public class ProductController {

    @Autowired
    private ProductSerive productService;
    @Autowired
    private ProductRepository productRepository;
    @PostMapping("/addproduct")
    public ResponseEntity<?> createProductWithVariants(@RequestBody ProductWithVariantsDTO dto) {

        Product product = productService.createProductWithVariants(dto);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/updateproduct")
    public ResponseEntity<?> editProductWithVariants(@RequestBody ProductWithVariantsImgDto dto) {
        System.out.println("dto = " + dto);
        Product product = productService.editProductWithVariants(dto);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/product")
    public ResponseEntity<?> getAllProduct() {
        return ResponseEntity.ok(productRepository.findAll());
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with id " + id + " not found");
        }
    }

}
