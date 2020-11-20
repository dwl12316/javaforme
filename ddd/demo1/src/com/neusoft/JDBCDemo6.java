package com.neusoft;

import com.neusoft.domain.Emp;
import com.neusoft.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo6 {
    public static void main(String[] args) throws Exception {
        List<Emp> empList = findall2();
        for (Emp e : empList) {
            System.out.println(e);
        }
    }

    public static List<Emp> findAll() {
        ArrayList<Emp> list = new ArrayList<Emp>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
            String sql = "select * from emp";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int empno = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String job = resultSet.getString(3);
                int Mgr = resultSet.getInt(4);
                Date hir = resultSet.getDate(5);
                int sal = resultSet.getInt(6);
                int com = resultSet.getInt(7);
                int dep = resultSet.getInt(8);
                Emp emp = new Emp(empno, name, job, Mgr, hir, sal, com, dep);
                list.add(emp);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Emp> findall2() throws Exception {
        ArrayList<Emp> list = new ArrayList<Emp>();
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from emp";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int empno = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String job = resultSet.getString(3);
            int Mgr = resultSet.getInt(4);
            Date hir = resultSet.getDate(5);
            int sal = resultSet.getInt(6);
            int com = resultSet.getInt(7);
            int dep = resultSet.getInt(8);
            Emp emp = new Emp(empno, name, job, Mgr, hir, sal, com, dep);
            list.add(emp);
        }
        JDBCUtils.close(resultSet,statement,connection);
        return list;
    }
}
