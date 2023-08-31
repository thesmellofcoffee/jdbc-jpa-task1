package com.example.taskOne.service;

import com.example.taskOne.dao.CategoryDao;
import com.example.taskOne.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryDao categoryDao;

    @Autowired
    public CategoryService(@Qualifier("postgres") CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public int addCategory(Category category){
        return categoryDao.insertCategory(category);
    }

    public List<Category> getAllCategory(){
        return categoryDao.selectAllCategory();
    }

    public int updateCategory(int id, String newName){
        return categoryDao.updateCategory(id, newName);
    }
    public int delete(int id){
        return categoryDao.delete(id);
    }

    public String getSubCategoryById(int id){
        return categoryDao.getSubCategoryById(id);
    }
}
