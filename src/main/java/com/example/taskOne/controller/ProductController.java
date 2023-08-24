package com.example.taskOne.controller;

import com.example.taskOne.model.Product;
import com.example.taskOne.service.ProductService;
import com.example.taskOne.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/product")
@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@NonNull @RequestBody Product product){
        productService.addProduct(product);
    }
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @PutMapping("/{id}")
    public int updateProduct(@PathVariable UUID id, @RequestBody Map<String, String> requestBody, Product product){
        String newName = requestBody.get("name");
        return productService.updateProduct(id, newName, product);
    }

    @DeleteMapping("/{id}")
    public int deleteProduct(@PathVariable UUID id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/getProductsByCategoryId/{id}")
    public List<Product> getProductsByCategoryId(@PathVariable UUID categoryId){
        return productService.getProductsByCategoryId(categoryId);
    }

    @GetMapping("/getCategoryByProductId/{id}")
    public UUID getCategoryByProductId(@PathVariable UUID productId){
        return productService.getCategoryByProductId(productId);
    }

}
