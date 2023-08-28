package com.example.taskOne.configs;

import com.example.taskOne.converter.ProductToProductDTOConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConversionConfig {

    @Bean
    public ProductToProductDTOConverter productToProductDTOConverter() {
        return new ProductToProductDTOConverter();
    }
}