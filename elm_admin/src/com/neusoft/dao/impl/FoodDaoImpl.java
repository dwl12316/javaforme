package com.neusoft.dao.impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    @Override
    public List<Food> listFood(Integer businessId) {
            List<Food> list = new ArrayList<>();
            try {
                connection = JDBCUtils.getConnection();
                String sql = "select * from food where businessId=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1,businessId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int foodId=resultSet.getInt(1);
                    String foodName=resultSet.getString(2);
                    String foodExplain=resultSet.getString(3);
                    double foodPrice=resultSet.getDouble(4);
                    Integer businessId1=resultSet.getInt(5);
                    Food food=new Food(foodId,foodName,foodExplain,foodPrice,businessId1);
                    list.add(food);
                }
                JDBCUtils.close(resultSet, preparedStatement, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
    }

    @Override
    public int saveFood(Food food) {
        String sql = "insert into food(foodName,foodExplain,foodPrice,businessId) values(?,?,?,?)";
        int i = 0;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,food.getFoodName());
            preparedStatement.setString(2,food.getFoodExplain());
            preparedStatement.setDouble(3,food.getFoodPrice());
            preparedStatement.setInt(4,food.getBusinessId());
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                i = resultSet.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
        return i;
    }

    @Override
    public int updateFood(Food food) {
        String sql = "update food set foodName = ?,foodExplain = ?,foodPrice = ?where foodId = ?";
        int i = 0;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,food.getFoodName());
            preparedStatement.setString(2, food.getFoodExplain());
            preparedStatement.setDouble(3, food.getFoodPrice());
            preparedStatement.setInt(4,food.getFoodId());
            i = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
        return i;
    }

    @Override
    public int removeFood(Integer foodId) {
        String sql = "delete from food where foodId=?";
        int i;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, foodId);
            i = preparedStatement.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            i = 0;
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
        return i;
    }

    @Override
    public Food getFoodById(Integer foodId) {
        Food food =null;
        String sql="select * from food where foodId= ?";
        try {
            connection=JDBCUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,foodId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int foodId1=resultSet.getInt(1);
                String foodName=resultSet.getString(2);
                String foodExplain=resultSet.getString(3);
                double foodPrice=resultSet.getDouble(4);
                int businessId=resultSet.getInt(5);
                food = new Food(foodId1,foodName,foodExplain,foodPrice,businessId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }
        return food;
    }
}
