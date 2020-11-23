package com.neusoft.dao.impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                    String businessId1=resultSet.getString(5);
                    Food food=new Food(foodId,foodName,foodExplain,foodPrice,businessId1);
                    list.add(food);
                }
                JDBCUtils.close(resultSet, preparedStatement, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
    }
}
