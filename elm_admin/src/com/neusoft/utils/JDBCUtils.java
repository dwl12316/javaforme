package com.neusoft.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource dataSource;

    static {

        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);
            dataSource= DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws Exception {
        return dataSource.getConnection();
    }

    public static void close(ResultSet resultSet, Statement statement,Connection connection){

            try {
                if(resultSet!=null) {
                    resultSet.close();
                }
                if(statement!=null){
                    statement.close();
                }
                if (connection!=null){
                    connection.close();
                }
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
    }

    public static void close(Statement statement,Connection connection){
        close(null,statement,connection);
    }
}
