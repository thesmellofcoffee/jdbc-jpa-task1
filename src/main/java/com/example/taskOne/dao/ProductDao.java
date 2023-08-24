package com.example.taskOne.dao;

import com.example.taskOne.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductDao {
    int insertProduct (UUID id, Product product);
    default int insertProduct(Product product){
        UUID id = UUID.randomUUID();
        return insertProduct(id, product);
    }
    List<Product> selectAllProduct();

    int updateProduct(UUID id, String newName, Product product);

    int deleteProduct(UUID id);
    int deleteProductByCategoryId(UUID id);
    List<Product> getProductsByCategoryId(UUID categoryId);
    UUID getCategoryByProductId(UUID productId);

}
