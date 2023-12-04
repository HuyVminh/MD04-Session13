package com.ra.model.service.product;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
    boolean saveOrUpdate(Category category);
    void delete(Integer id);
}
