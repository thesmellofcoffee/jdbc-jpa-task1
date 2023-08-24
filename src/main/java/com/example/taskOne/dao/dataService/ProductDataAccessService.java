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
    public int insertProduct(UUID id, Product product) {
        final String sql = "INSERT INTO product (id, name, category_id) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, id, product.getName(), product.getCategory_id());
    }

    @Override
    public List<Product> selectAllProduct() {
        final String sql = "SELECT id, name, category_id FROM product"; // Include category_id in the SQL query
        List<Product> products = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            UUID category_id = UUID.fromString(resultSet.getString("category_id")); // Retrieve category_id
            return new Product(id, name, category_id); // Use the correct constructor
        });
        return products;
    }

    @Override
    public int updateProduct(UUID id, String newName, Product product){
        product = new Product(id, newName, product.getCategory_id());
        String sql = "UPDATE product SET name = ? WHERE id = ? ";
        return jdbcTemplate.update(sql, newName, id);
    }

    @Override
    public int deleteProduct(UUID id){
        String sql = "DELETE FROM product WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int deleteProductByCategoryId(UUID id){
        String sql = "DELETE FROM product WHERE category_id = ?";
        return jdbcTemplate.update(sql, id);
    }


    @Override
    public List<Product> getProductsByCategoryId(UUID categoryId) {
        String sql = "SELECT * FROM product WHERE category_id = ?";
        return jdbcTemplate.query(sql, new Object[]{categoryId}, (resultSet, rowNum) -> {
            UUID productId = UUID.fromString(resultSet.getString("id"));
            String productName = resultSet.getString("name");
            // Diğer sütunları da burada çekebilirsiniz
            return new Product(productId, productName, categoryId);
        });
    }

    @Override
    public UUID getCategoryByProductId(UUID productId) {
        String sql = "SELECT category_id FROM product WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productId}, UUID.class);
    }

}
