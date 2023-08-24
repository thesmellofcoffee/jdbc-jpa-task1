package com.example.taskOne.service;

import com.example.taskOne.dao.ProductDao;
import com.example.taskOne.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductDao productDao;

    @Autowired
    public ProductService(@Qualifier("postgresTwo") ProductDao productDao) {
        this.productDao = productDao;
    }

    public int addProduct(Product product){
        return productDao.insertProduct(product);
    }

    public List<Product> getAllProduct(){
        return productDao.selectAllProduct();
    }
    public int updateProduct(UUID id, String newName, Product product){
        return productDao.updateProduct(id, newName, product);
    }
    public int deleteProduct(UUID id){
        return productDao.deleteProduct(id);
    }
    public int deleteProductByCategoryId(UUID id){
        return productDao.deleteProductByCategoryId(id);
    }
    public List<Product> getProductsByCategoryId(UUID categoryId){
        return productDao.getProductsByCategoryId(categoryId);
    }
    public UUID getCategoryByProductId(UUID productId){
        return productDao.getCategoryByProductId(productId);
    }
}
