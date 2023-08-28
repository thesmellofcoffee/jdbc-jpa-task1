package com.example.taskOne.service;

import com.example.taskOne.converter.ProductConverter;
import com.example.taskOne.dao.ProductDao;
import com.example.taskOne.dto.ProductDTO;
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
        ProductDTO productDTO = ProductConverter.toDTO(product);

        return productDao.insertProduct(product);
    }

    public List<Product> getAllProduct(){
        return productDao.selectAllProduct();
    }
    public int updateProduct(int id, String newName){
        return productDao.updateProduct(id, newName);
    }
    public int deleteProduct(int id){
        return productDao.deleteProduct(id);
    }
    public List<Product> getProductsByCategoryId(int categoryId){
        return productDao.getProductsByCategoryId(categoryId);
    }
    public int getCategoryByProductId(int productId){
        return productDao.getCategoryByProductId(productId);
    }
}
