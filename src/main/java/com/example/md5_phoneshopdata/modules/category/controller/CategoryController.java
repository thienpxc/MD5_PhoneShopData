package com.example.md5_phoneshopdata.modules.category.controller;

import com.example.md5_phoneshopdata.modules.category.Category;
import com.example.md5_phoneshopdata.modules.category.service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;


    
    @GetMapping("/admin/category")
    public List<Category> getAllCategory(){
           return categoryService.findAll();

//       return categoryService.findByStatus(true);
    }
    @GetMapping("/admin/product/category")
    public List<Category> getStatusCategory(){
//            return categoryService.findAll();


        return categoryService.findByStatus(true);
    }

    @PostMapping("/admin/category/delete/{id}")
    public void deleteCategory(@PathVariable Integer id){
        categoryService.delete(id);
    }

    @PostMapping("/admin/category/add")
    public void addCategory(@RequestBody Category category){
        categoryService.save(category);
    }


    @GetMapping("/admin/category/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return categoryService.findById(id);
    }

    @PostMapping("/admin/category/update")
    public void updateCategory(@RequestBody Category category){
        categoryService.save(category);
    }


}
