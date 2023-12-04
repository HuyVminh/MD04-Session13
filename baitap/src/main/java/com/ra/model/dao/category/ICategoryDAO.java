package com.ra.model.dao.category;

import com.ra.model.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICategoryDAO {
    List<Category> findAll();
    Category findById(Integer id);
    boolean saveOrUpdate(Category category);
    void delete(Integer id);
}
