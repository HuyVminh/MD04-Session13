package com.ra.model.service.product;

import com.ra.model.dao.category.ICategoryDAO;
import com.ra.model.dao.product.IProductDAO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.util.ConnectionDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductServiceIMPL implements IProductService {
    @Autowired
    IProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productDAO.findById(id);
    }

    @Override
    public boolean saveOrUpdate(Category category) {

        return false;
    }

    @Override
    public void delete(Integer id) {

    }
}
