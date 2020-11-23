package com.neusoft.dao.impl;

import com.neusoft.dao.AdminDao;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    @Override
    public List<Admin> listAdmin() {
        List<Admin> list = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from admin";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int adminId=resultSet.getInt(1);
                String adminName=resultSet.getString(2);
                String password=resultSet.getString(3);
                Admin admin=new Admin(adminId,adminName,password);
                list.add(admin);
            }
            JDBCUtils.close(resultSet, preparedStatement, connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Admin getAdminByNameAndPassword(String adminName, String password) {
        Admin admin=null;
        String sql="select * from admin where adminName=? and password= ?";
        try {
            connection=JDBCUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,adminName);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                admin = new Admin(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }
        return admin;
    }
}
