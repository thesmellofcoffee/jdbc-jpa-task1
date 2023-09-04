package com.example.taskOne.dao.dataService;

import com.example.taskOne.dao.ProductDao;
import com.example.taskOne.exception.EmptyIdException;
import com.example.taskOne.exception.ProductNotfoundException;
import com.example.taskOne.model.Category;
import com.example.taskOne.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
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

        try {
            if (product.getName() == null) {
                throw new EmptyIdException();
            } else {
                return jdbcTemplate.update(sql, newId, product.getName(), product.getCategory().getId());
            }

        } catch (Exception e) {
            throw new EmptyIdException();
        }

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

        try {
            int rowsAffected = jdbcTemplate.update(sql, id);

            if (rowsAffected == 0) {
                throw new ProductNotfoundException();
            }


            return jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            throw new ProductNotfoundException();
        }
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        String sql = "SELECT product.id, product.name, product.category_id, category.name AS category_name " +
                "FROM product " +
                "JOIN category ON product.category_id = category.id " +
                "WHERE product.category_id = ?";

        return jdbcTemplate.query(sql, new Object[]{categoryId}, (resultSet, rowNum) -> {
            int productId = resultSet.getInt("id");
            String productName = resultSet.getString("name");
            int categoryId1 = resultSet.getInt("category_id");
            String categoryName = resultSet.getString("category_name");
            Category category = new Category(categoryId1, categoryName);
            return new Product(productId, productName, category);
        });
    }


    @Override
    public int getCategoryByProductId(int productId) {
        String sql = "SELECT category_id FROM product WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productId}, int.class);
    }


    @Override
    public Product getProductById(int id) {

        String sql = "SELECT product.id, product.name, category.id AS category_id, category.name AS category_name " +
                "FROM product " +
                "INNER JOIN category ON product.category_id = category.id " +
                "WHERE product.id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
                int productId = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                int categoryId = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("category_name");
                Category category = new Category(categoryId, categoryName);
                return new Product(productId, productName, category);
            });
        } catch (EmptyResultDataAccessException e) {
            throw new ProductNotfoundException();
        }
    }

    @Override
    public Optional<Product> findByItemSku(long itemSku) {
        return Optional.empty();
    }
}

