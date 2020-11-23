package com.neusoft;

import com.neusoft.dao.impl.AdminDaoImpl;
import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.dao.impl.FoodDaoImpl;
import com.neusoft.domain.Admin;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        BusinessDaoImpl dao= new BusinessDaoImpl();
        List<Business> list= dao.listBusiness(null,null); ;
        for (Business b: list) {
            System.out.println(b);
        }
//        Business b=dao.getBusinessId(10001);
//        System.out.println(b);
        Business business = new Business();
        business.setBusinessName("真好吃");
        business.setBusinessAddress("dasdas");
        business.setBusinessExplain("dasdas");
        business.setDeliveryPrice(5.);
        business.setStarPrice(2.);
        business.setBusinessId(10012);
        dao.updateBusiness(business);
    }
}
