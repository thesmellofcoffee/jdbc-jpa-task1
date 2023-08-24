package com.example.taskOne.dao.dataService;

import com.example.taskOne.dao.ProductDao;
import com.example.taskOne.model.Category;
import com.example.taskOne.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("postgresTwo")
public class ProductDataAccessService implements ProductDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertProduct(Product product) {
        int lastInsertedId = 0;

        lastInsertedId = getLastInsertedProductId();

        int newId = lastInsertedId + 1;
        final String sql = "INSERT INTO product (id, name, category_id) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, newId, product.getName(), product.getCategory().getId());
    }
    public int getLastInsertedProductId() {
        String query = "SELECT COALESCE(MAX(id), 0) FROM product";
        return jdbcTemplate.queryForObject(query, Integer.class);
    }
    @Override
    public List<Product> selectAllProduct() {
        final String sql = "SELECT p.id, p.name, c.id AS category_id, c.name AS category_name FROM product p INNER JOIN category c ON p.category_id = c.id";
        List<Product> products = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int categoryId = resultSet.getInt("category_id");
            String categoryName = resultSet.getString("category_name");
            Category category = new Category(categoryId, categoryName);
            return new Product(id, name, category);
        });
        return products;
    }



    @Override
    public int updateProduct(int id, String newName) {
        String sql = "UPDATE product SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, newName, id);
    }

    @Override
    public int deleteProduct(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        String sql = "SELECT * FROM product WHERE category_id = ?";
        return jdbcTemplate.query(sql, new Object[]{categoryId}, (resultSet, rowNum) -> {
            int productId = Integer.parseInt(resultSet.getString("id"));
            String productName = resultSet.getString("name");
            return new Product(productId, productName);
        });
    }

    @Override
    public int getCategoryByProductId(int productId) {
        String sql = "SELECT category_id FROM product WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productId}, int.class);
    }

}
