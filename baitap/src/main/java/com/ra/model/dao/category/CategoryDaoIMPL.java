package com.ra.model.dao.category;

import com.ra.model.entity.Category;
import com.ra.util.ConnectionDatabase;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoIMPL implements ICategoryDAO {
    @Override
    public List<Category> findAll() {
        Connection connection = null;
        List<Category> categories = new ArrayList<>();
        try {
            connection = ConnectionDatabase.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_SHOW_CATEGORY}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setStatus(resultSet.getBoolean("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeConnection(connection);
        }
        return categories;
    }

    @Override
    public Category findById(Integer id) {
        Connection connection = null;
        Category category = new Category();
        try {
            connection = ConnectionDatabase.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_FIND_CATEGORY_BY_ID(?)}");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setStatus(resultSet.getBoolean("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeConnection(connection);
        }
        return category;
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
