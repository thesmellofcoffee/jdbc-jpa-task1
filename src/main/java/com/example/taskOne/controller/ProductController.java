package com.example.taskOne.controller;

import com.example.taskOne.dto.ProductDTO;
import com.example.taskOne.exception.ProductNotfoundException;
import com.example.taskOne.model.Product;
import com.example.taskOne.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RequestMapping("/product")
@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void addProduct(@NonNull @RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    @PutMapping("/{id}")
    public int updateProduct(
            @PathVariable int id,
            @RequestBody Map<String, String> requestBody
    ) {
        String newName = requestBody.get("name");
        return productService.updateProduct(id, newName);
    }

    @DeleteMapping("/{id}")
    public int deleteProduct(@PathVariable int id) {

        return productService.deleteProduct(id);
    }

    @GetMapping("/getProductsByCategoryId/{categoryId}")
    public List<Product> getProductsByCategoryId(@PathVariable int categoryId) {
        return productService.getProductsByCategoryId(categoryId);
    }

    @GetMapping("/getCategoryByProductId/{productId}")
    public int getCategoryByProductId(@PathVariable int productId) {
        return productService.getCategoryByProductId(productId);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
}
