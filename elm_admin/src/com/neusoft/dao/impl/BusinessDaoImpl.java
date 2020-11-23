package com.neusoft.dao.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusinessDaoImpl implements BusinessDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Scanner input=new Scanner(System.in);

    @Override
    public List<Business> listBusiness(String businessName,String businessAddress) {
        List<Business> list = new ArrayList<>();
        try {
            connection = JDBCUtils.getConnection();
            //String sql = "select * from business ";
            StringBuffer stringBuffer=new StringBuffer("select * from business where 1=1");
            if(businessName!=null && !businessName.equals("")) {
                stringBuffer.append(" and businessName LIKE '%"+businessName+"%'");
            }
            if(businessAddress!=null && !businessAddress.equals("")){
                stringBuffer.append(" and businessAddress like '%"+businessAddress+"%'");
            }
            preparedStatement = connection.prepareStatement(String.valueOf(stringBuffer));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int businessId = resultSet.getInt(1);
                String password = resultSet.getString(2);
                String businessName1 = resultSet.getString(3);
                String businessAddress1 = resultSet.getString(4);
                String businessExplain = resultSet.getString(5);
                double starPrice = resultSet.getDouble(6);
                double deliveryPrice = resultSet.getDouble(7);
                Business business = new Business(businessId, password, businessName1, businessAddress1, businessExplain, starPrice, deliveryPrice);
                list.add(business);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
        return list;
    }

    @Override
    public int saveBusiness(String businessName) {
        String sql = "insert into business(businessName,password) values(?,'123')";
        int i = 0;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, businessName);
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
    public int removeBusiness(int businessId) {
        String sql = "delete from business where businessId=?";
        int i = 0;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, businessId);
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
    public int updateBusiness(Business business) {
        String sql = "update business set businessName = ?,businessAddress = ?,businessExplain = ?,starPrice = ?, deliveryPrice = ? where businessId = ?";
        int i = 0;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, business.getBusinessName());
            preparedStatement.setString(2,business.getBusinessAddress());
            preparedStatement.setString(3, business.getBusinessExplain());
            preparedStatement.setDouble(4, business.getStarPrice());
            preparedStatement.setDouble(5, business.getDeliveryPrice());
            preparedStatement.setInt(6, business.getBusinessId());
            i = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
        return i;
    }

    @Override
    public Business getBusinessId(int businessId) {
        Business business =null;
        String sql="select * from business where businessId= ?";
        try {
            connection=JDBCUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,businessId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int bId = resultSet.getInt(1);
                String password = resultSet.getString(2);
                String businessName = resultSet.getString(3);
                String businessAddress = resultSet.getString(4);
                String businessExplain = resultSet.getString(5);
                double starPrice = resultSet.getDouble(6);
                double deliveryPrice = resultSet.getDouble(7);
                business = new Business(bId, password, businessName, businessAddress, businessExplain, starPrice, deliveryPrice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }
        return business;
    }

    @Override
    public Business getBusinessIdAndBusinessPassword(String businessId, String password) {
        Business business=null;
        String sql="select * from business where businessId=? and password= ?";
        try {
            connection=JDBCUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,businessId);
            preparedStatement.setString(2,password);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bId = resultSet.getInt(1);
                String password1 = resultSet.getString(2);
                String businessName = resultSet.getString(3);
                String businessAddress = resultSet.getString(4);
                String businessExplain = resultSet.getString(5);
                double starPrice = resultSet.getDouble(6);
                double deliveryPrice = resultSet.getDouble(7);
                business = new Business(bId, password1, businessName, businessAddress, businessExplain, starPrice, deliveryPrice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }
        return business;
    }

    @Override
    public int updateBusinessPassword(Integer businessId,String newPassword) {
        String sql="update business set password=? where businessId=?";
        int res=0;
        try {
            connection=JDBCUtils.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,newPassword);
            preparedStatement.setInt(2,businessId);
            res=preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(resultSet,preparedStatement,connection);
        }
        return res;
    }
}
