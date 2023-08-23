package com.example.taskOne.dao;

import com.example.taskOne.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryDao {
    int insertCategory (UUID id, Category category);
    default int insertCategory(Category category){
        UUID id = UUID.randomUUID();
        return insertCategory(id, category);
    }
    List<Category> selectAllCategory();

    int updateCategory(UUID id, String newName);

    int delete(UUID id);
}
