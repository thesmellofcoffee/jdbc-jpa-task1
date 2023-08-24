package com.example.taskOne.controller;

import com.example.taskOne.model.Category;
import com.example.taskOne.service.CategoryService;
import com.example.taskOne.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@RequestMapping("/category")
@RestController
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @PostMapping
    public void addCategory(@NonNull @RequestBody Category category){
        categoryService.addCategory(category);
    }
    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @PutMapping("/{id}")
    public int updateCategory(@PathVariable int id, @RequestBody Map<String, String> requestBody) {
        String newName = requestBody.get("name");
        return categoryService.updateCategory(id, newName);
    }
    @DeleteMapping("/{id}")
    public int deleteCategory(@PathVariable int id){
        //productService.deleteProductByCategoryId(id);
        return categoryService.delete(id);
    }
}
