package com.ra.model.service.category;

import com.ra.model.dao.category.ICategoryDAO;
import com.ra.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceIMPL implements ICategoryService {
    @Autowired
    private ICategoryDAO categoryDAO;
    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryDAO.findById(id);
    }

    @Override
    public boolean saveOrUpdate(Category category) {
        return categoryDAO.saveOrUpdate(category);
    }

    @Override
    public void delete(Integer id) {
        categoryDAO.delete(id);
    }
}
