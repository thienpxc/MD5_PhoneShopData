package com.example.md5_phoneshopdata.modules.product.user;

import com.example.md5_phoneshopdata.modules.product.Product;
import com.example.md5_phoneshopdata.modules.product.admin.repository.IProductRepository;
import com.example.md5_phoneshopdata.modules.product.admin.service.IProductSerive;
import com.example.md5_phoneshopdata.modules.product.user.productDao.IProductUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class ProductUserController {

    @Autowired
    private IProductSerive productService;
    @Autowired
    private IProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productService.findByStatus(true);

    }

}
