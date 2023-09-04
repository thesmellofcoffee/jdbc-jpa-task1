package com.example.taskOne.dao;

import com.example.taskOne.dao.dataService.ProductDataAccessService;
import com.example.taskOne.model.Product;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductDao {
    int insertProduct (Product product);

    List<Product> selectAllProduct();

    int updateProduct(int id, String newName);

    int deleteProduct(int id);
    List<Product> getProductsByCategoryId(int categoryId);
    int getCategoryByProductId(int productId);
    Product getProductById(int id);
    Optional<Product> findByItemSku(@Param("itemSku") long itemSku);

}
