package com.neusoft;

import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo3 {
    public static void main(String[] args) {
        try {
            Connection connection = JDBCUtils.getConnection();
            Statement statement =connection.createStatement();
            String username;
            String password;
            Scanner input = new Scanner(System.in);
            System.out.print("输入用户名:");
            username=input.next();
            System.out.print("输入密码:");
            password=input.next();
            String sql="select * from user where username='"+username+" 'and password='"+password+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next())
                System.out.println("登录成功");
            else
                System.out.println("登录失败");
            JDBCUtils.close(resultSet,statement,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
