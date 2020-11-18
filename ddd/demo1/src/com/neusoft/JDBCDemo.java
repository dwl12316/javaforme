package com.neusoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
            String sql = "update account set balance = 500 where id=1";
            statement = connection.createStatement();
            int i = statement.executeUpdate(sql);

            if(i!=0){
                System.out.println("1111");
            }
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
