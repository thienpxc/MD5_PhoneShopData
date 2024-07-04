package com.example.md5_phoneshopdata.modules.category.controller;

import com.example.md5_phoneshopdata.modules.category.Category;
import com.example.md5_phoneshopdata.modules.category.service.ICategoryService;
import com.example.md5_phoneshopdata.modules.users.service.IUserSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    
    @GetMapping("/category")
    public List<Category> getAllCategory(){
            return categoryService.findAll();

//        return categoryService.findByStatus(true);
    }

    @PostMapping("/category/delete/{id}")
    public void deleteCategory(@PathVariable Integer id){
        categoryService.delete(id);
    }

    @PostMapping("/category/add")
    public void addCategory(@RequestBody Category category){
        categoryService.save(category);
    }

    @PostMapping("/category/update")
    public void updateCategory(@RequestBody Category category){
        categoryService.save(category);
    }


}
