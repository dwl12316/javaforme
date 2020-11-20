package com.neusoft;

import com.neusoft.domain.Emp;

import java.sql.*;

public class JDBCDemo2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root");
            String sql ="select * from emp";
            Statement statement= connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int empno=resultSet.getInt(1);
                String name =resultSet.getString(2);
                String job =resultSet.getString(3);
                int Mgr =resultSet.getInt(4);
                Date hir =resultSet.getDate(5);
                int sal =resultSet.getInt(6);
                int com=resultSet.getInt(7);
                int dep =resultSet.getInt(8);
                Emp emp=new Emp(empno,name,job,Mgr,hir,sal,com,dep);
                //System.out.println("empno:"+empno+" name:"+name+" job:"+job+" MGR:"+Mgr+" HIREDATE:"+hir+" SAL:"+sal+" COMM:"+com+" DEPTNo:"+dep);
                System.out.println(emp);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
