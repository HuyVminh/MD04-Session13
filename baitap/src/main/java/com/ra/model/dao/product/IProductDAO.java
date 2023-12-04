package com.ra.model.dao.product;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> findAll();
    Product findById(Integer id);
    boolean saveOrUpdate(Category category);
    void delete(Integer id);
}
