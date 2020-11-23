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
    @Override
    public List<Food> listFood() {
            List<Food> list = new ArrayList<>();
            try {
                Connection connection = JDBCUtils.getConnection();
                String sql = "select * from food";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int foodId=resultSet.getInt(1);
                    String foodName=resultSet.getString(2);
                    String foodExplain=resultSet.getString(3);
                    double foodPrice=resultSet.getDouble(4);
                    String businessId=resultSet.getString(5);
                    Food food=new Food(foodId,foodName,foodExplain,foodPrice,businessId);
                    list.add(food);
                }
                JDBCUtils.close(resultSet, preparedStatement, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return list;
    }
}
