package com.neusoft.view.Impl;

import com.neusoft.dao.impl.AdminDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.view.AdminView;

import java.util.Scanner;

public class AdminViewImpl implements AdminView {
    @Override
    public Admin login() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名:");
        String adminName= input.next();
        System.out.print("请输入密码:");
        String password=input.next();
        AdminDaoImpl dao=new AdminDaoImpl();
        Admin admin=dao.getAdminByNameAndPassword(adminName,password);
        return admin;
    }
}
