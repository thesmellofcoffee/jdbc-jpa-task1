package com.example.taskOne.converter;

import com.example.taskOne.dto.ProductDTO;
import com.example.taskOne.model.Product;
import org.springframework.core.convert.converter.Converter;

public class ProductToProductDTOConverter implements Converter<Product, ProductDTO> {

    @Override
    public ProductDTO convert(Product source) {
        ProductDTO target = new ProductDTO();
        target.setName(source.getName());

        return target;
    }
}