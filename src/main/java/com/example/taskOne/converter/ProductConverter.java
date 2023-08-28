package com.example.taskOne.converter;

import com.example.taskOne.dto.ProductDTO;
import com.example.taskOne.model.Product;

public class ProductConverter {
    public static ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO(product.getName());
        dto.setProductName(product.getName());
        return dto;
    }

    public static Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getProductName());
        return product;
    }
}



