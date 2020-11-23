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
        }else {
            System.out.println("商家编号"+"\t"+"商家名称"+"\t"+"商家地址"+"\t"+"商家备注"+"\t"+"商家配送费"+"\t"+"商家起送费");
            for (Business b :list){
                System.out.println(b.getBusinessId() +"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getDeliveryPrice()+"\t"+b.getStarPrice());
            }
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
        }else {
            System.out.println("商家编号"+"\t"+"商家名称"+"\t"+"商家地址"+"\t"+"商家备注"+"\t"+"商家配送费"+"\t"+"商家起送费");
            for (Business b :list){
                System.out.println(b.getBusinessId() +"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getDeliveryPrice()+"\t"+b.getStarPrice());
            }
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

    @Override
    public Business login() {
        System.out.print("输入商家号:");
        String businessName =input.next();
        System.out.print("请输入密码:");
        String password=input.next();
        Business business=dao.getBusinessIdAndBusinessPassword(businessName,password);
        return business;
    }

    @Override
    public void outBusinessbyId(Integer businessId) {
        Business b=dao.getBusinessId(businessId);
        System.out.println("商家编号"+"\t"+"商家名称"+"\t"+"商家地址"+"\t"+"商家备注"+"\t"+"商家配送费"+"\t"+"商家起送费");
        System.out.println(b.getBusinessId() +"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getDeliveryPrice()+"\t\t\t"+b.getStarPrice());
    }

    @Override
    public void updateBusiness(Business business) {
        String []name= new String[]{"商家名称","商家地址", "商家备注", "商家配送费", "商家起送费"};
        String s = null;
        double x=0;
        int i=0;
        while (i<5){
            System.out.print("请问你是否要修改"+name[i]+"y/n:");
            if(input.next().equals("y")) {
                System.out.print("请输入新的"+name[i]+":");
                if(i<=2)
                    s=input.next();
                else
                    x=input.nextDouble();
                switch (i) {
                    case 0: business.setBusinessName(s);break;
                    case 1: business.setBusinessAddress(s);break;
                    case 2: business.setBusinessExplain(s);break;
                    case 3: business.setDeliveryPrice(x);break;
                    case 4: business.setStarPrice(x);break;
                    default:break;
                }
            }
            i++;
        }
        dao.updateBusiness(business);
    }

    @Override
    public void updatePassword(Integer businessId) {
        BusinessDao dao =new BusinessDaoImpl();
        Business business=dao.getBusinessId(businessId);
        while (true) {
            System.out.print("请输入旧密码:");
            String oldPass = input.next();
            System.out.print("请输入新密码:");
            String newPass = input.next();
            System.out.print("请再次输入新密码:");
            String beginNewPass = input.next();
            if (!business.getPassword().equals(oldPass)) {
                System.out.println("你的密码错了，请重新输入");
            } else if (!newPass.equals(beginNewPass)) {
                System.out.println("两次密码不一致");
            } else {
                int i=dao.updateBusinessPassword(businessId,newPass);
                if(i!=0)
                    System.out.println("更新成功");
                else
                    System.out.println("更新失败");
                break;
            }
        }
    }
}
