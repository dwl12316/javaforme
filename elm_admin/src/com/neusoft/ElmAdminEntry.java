package com.neusoft;

import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.view.AdminView;
import com.neusoft.view.Impl.AdminViewImpl;
import com.neusoft.view.Impl.BusinessViewImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElmAdminEntry {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("---------------------------------------");
        System.out.println("-------------欢迎进入饿了么后台------------");
        System.out.println("---------------------------------------");
        AdminViewImpl adminView =new AdminViewImpl();
        Admin admin=adminView.login();
        if(admin!=null){
            int meau=0;
            System.out.println("登录成功");
            BusinessViewImpl businessView=new BusinessViewImpl();
            while (meau!=5){
                System.out.println("---------------");
                System.out.println("1. 查看所有商家");
                System.out.println("2. 搜索商家");
                System.out.println("3. 新建商家");
                System.out.println("4. 删除商家");
                System.out.println("5. 退出系统");
                System.out.println("---------------");
                System.out.print("输入你的选择:");
                meau=input.nextInt();
                int id,key;
                switch (meau){
                    case 1:
                        businessView.listAllBusinesses();
                        break;
                    case 2:
                        businessView.selectBusinesses();
                        break;
                    case 3:
                        businessView.saveBusiness();
                        break;
                    case 4:
                        businessView.removeBusiness();
                        break;
                    case 5:
                        System.out.println("欢迎下次进入");
                        break;
                    default:
                        System.out.println("没有这个选项");
                        break;
                }
            }
        }
        else {
            System.out.println("登录失败");
        }
    }

}
