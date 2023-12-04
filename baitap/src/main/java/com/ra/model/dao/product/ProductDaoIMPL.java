package com.ra.model.dao.product;

import com.ra.model.dao.category.ICategoryDAO;
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
public class ProductDaoIMPL implements IProductDAO {
    @Autowired
    ICategoryDAO categoryDAO;

    @Override
    public List<Product> findAll() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = ConnectionDatabase.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_SHOW_PRODUCT}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                Category category = categoryDAO.findById(resultSet.getInt("category_id"));
                product.setCategory(category);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeConnection(connection);
        }
        return products;
    }

    @Override
    public Product findById(Integer id) {
        Connection connection = null;
        Product product = new Product();
        try {
            connection = ConnectionDatabase.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_FIND_CATEGORY_BY_ID(?)}");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                product.setProductId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                Category category = categoryDAO.findById(resultSet.getInt("category_id"));
                product.setCategory(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeConnection(connection);
        }
        return product;
    }

    @Override
    public boolean saveOrUpdate(Category category) {
        Connection connection = null;
        connection = ConnectionDatabase.openConnection();
        int check = 0;
        try {
            if (category.getCategoryId() == 0) {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_ADD_CATEGORY(?)}");
                callableStatement.setString(1, category.getCategoryName());
                check = callableStatement.executeUpdate();
            } else {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_UPDATE_CATEGORY(?,?,?)}");
                callableStatement.setInt(1, category.getCategoryId());
                callableStatement.setString(2, category.getCategoryName());
                callableStatement.setBoolean(3, category.isStatus());
                check = callableStatement.executeUpdate();
            }
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeConnection(connection);
        }
        return false;
    }

    @Override
    public void delete(Integer id) {

    }
}
