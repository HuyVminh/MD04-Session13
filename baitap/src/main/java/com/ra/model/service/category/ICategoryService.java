package com.ra.model.service.category;

import com.ra.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    boolean saveOrUpdate(Category category);
    void delete(Integer id);
}
