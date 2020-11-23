package com.neusoft.view.Impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {
    BusinessDao dao=new BusinessDaoImpl();
    Scanner input =new Scanner(System.in);
    List<Business> list;
    @Override
    public void listAllBusinesses() {
        list= dao.listBusiness(null,null);
        if (list.size()==0){
            System.out.println("无商家");
        }
        for (Business b: list) {
            System.out.println(b);
        }
    }

    @Override
    public void selectBusinesses() {
        String m="";
        String n="";
        String key;
        System.out.print("是否要输入商家名关键字y/n:");
        key=input.next();
        if(key.equals("y")){
            System.out.print("请输入商家名关键字:");
            m=input.next();
        }
        System.out.print("是否输入商家地址关键字y/n:");
        key=input.next();
        if(key.equals("y")) {
            System.out.print("请输入商家地址关键字:");
            n = input.next();
        }
        list=dao.listBusiness(m,n);
        if(list.size()==0){
            System.out.println("查询无结果");
        }
        for (Business b: list) {
            System.out.println(b);
        }
    }

    @Override
    public void saveBusiness() {
        System.out.print("请输入新商家名称:");
        String businessName=input.next();
        int businessId=dao.saveBusiness(businessName);
        Business business=dao.getBusinessId(businessId);
        if(business!=null){
            System.out.println(business);
        }else {
            System.out.println("添加失败");
        }
    }

    @Override
    public void removeBusiness() {
        System.out.print("输入商家ID:");
        int id=input.nextInt();
        System.out.print("确认要删除吗y/n:");
        if(input.next().equals("y")) {
            int key = dao.removeBusiness(id);
            if (key == 1)
                System.out.println("删除成功");
            else
                System.out.println("无此商家");
        }
    }
}
