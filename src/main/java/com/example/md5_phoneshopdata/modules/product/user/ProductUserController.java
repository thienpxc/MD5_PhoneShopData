package com.example.md5_phoneshopdata.modules.product.user;

import com.example.md5_phoneshopdata.modules.product.user.productDao.IProductUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductUserController {
    @Autowired
    private IProductUserDao productUserDao;
    @GetMapping("/all")
    public String getAllProducts() {
        productUserDao.findAll(true);
        return null;
    }

}
