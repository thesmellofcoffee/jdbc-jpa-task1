package com.example.taskOne.dao.dataService;

import com.example.taskOne.dao.CategoryDao;
import com.example.taskOne.enums.SubCategory;
import com.example.taskOne.model.Category;
import com.example.taskOne.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.UUID;

@Repository("postgres")
public class CategoryDataAccessService extends CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCategory(Category category) {
        int lastInsertedId = getLastInsertedCategoryId();
        int newId = lastInsertedId + 1;
        final String sql = "INSERT INTO category (id, name, subCategory) VALUES (?, ?, ?)";

        return jdbcTemplate.update(sql, newId, category.getName(),category.getSubCategory());



    }

    public int getLastInsertedCategoryId() {
        String query1 = "SELECT COALESCE(MAX(id), 0) FROM category";
        return jdbcTemplate.queryForObject(query1, Integer.class);
    }

    public String getSubCategoryById(int id) {
        String sql = "SELECT subcategory FROM category WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, id);
    }



    @Override
    public List<Category> selectAllCategory() {
        final String sql = "SELECT id, name, subcategory FROM category";
        List<Category> categories = jdbcTemplate.query(sql, (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String subCategoryStr = resultSet.getString("subcategory");
            SubCategory subCategory = SubCategory.valueOf(subCategoryStr); // Enum değerini al
            return new Category(id, name, subCategory);
        });
        return categories;
    }


    @Override
    public int updateCategory(int id, String newName) {
        Category category = new Category(id, newName); // Yeni Category nesnesi oluşturuluyor
        String sql = "UPDATE category SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, newName, id);
    }

    @Override
    public int delete(int id){
        String sql = "DELETE FROM category WHERE id = ?";
        return jdbcTemplate.update(sql, id);

    }

}
