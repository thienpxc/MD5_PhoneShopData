package com.example.md5_phoneshopdata.modules.product.admin;



import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.product.admin.dto.ProductWithVariantsDTO;
import com.example.md5_phoneshopdata.modules.product.admin.service.ProductSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/admin")
@CrossOrigin("*")

public class ProductController {

    @Autowired
    private ProductSerive productService;

    @PostMapping("/addproduct")
    public ResponseEntity<?> createProductWithVariants(@RequestBody ProductWithVariantsDTO dto) {
        System.out.println("dto sssssssssssssssss= " + dto);
        Product product = productService.createProductWithVariants(dto);
        return ResponseEntity.ok(product);
    }

}
