package com.example.taskOne.dao;

import com.example.taskOne.model.Category;

import java.util.List;
import java.util.UUID;

public abstract class CategoryDao {
    public abstract int insertCategory (Category category);

    public abstract List<Category> selectAllCategory();

    public abstract int updateCategory(int id, String newName);

    public abstract int delete(int id);

    public abstract String getSubCategoryById(int id);
}
