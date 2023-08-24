package com.example.taskOne.dao;

import com.example.taskOne.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryDao {
    int insertCategory (Category category);

    List<Category> selectAllCategory();

    int updateCategory(int id, String newName);

    int delete(int id);
}
