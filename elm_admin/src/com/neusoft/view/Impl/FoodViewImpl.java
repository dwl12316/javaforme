package com.neusoft.view.Impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.dao.impl.FoodDaoImpl;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodViewImpl implements FoodView {
    FoodDao foodDao=new FoodDaoImpl();
    Scanner input=new Scanner(System.in);
    @Override
    public void showFoodList(Integer businessId) {
        List<Food> foods=new  ArrayList<Food>();
        foods=foodDao.listFood(businessId);
        for (Food f:foods) {
            System.out.println(f);
        }
    }

    @Override
    public void saveFood(Integer businessId) {
        String foodName;
        String foodExplain;
        double foodPrice;
        System.out.print("输入食品名:");
        foodName=input.next();
        System.out.print("输入食品简介:");
        foodExplain=input.next();
        System.out.print("输入食品价格:");
        foodPrice=input.nextDouble();
        Food food=new Food(null,foodName,foodExplain,foodPrice,businessId);
        int foodId=foodDao.saveFood(food);
        if(foodDao.getFoodById(foodId)!=null)
            System.out.println("添加成功");
        else
            System.out.println("添加失败");
    }

    @Override
    public void updateFood(Integer businessId) {
        System.out.print("请输入你要修改的食品id:");
        int foodId=input.nextInt();
        Food food=foodDao.getFoodById(foodId);
        if(food!=null&&food.getBusinessId().equals(businessId)){
            String []name= new String[]{"食品名称","食品介绍", "食品价格"};
            String s = null;
            double x=0;
            int i=0;
            while (i<3){
                System.out.print("请问你是否要修改"+name[i]+"y/n:");
                if(input.next().equals("y")) {
                    System.out.print("请输入新的"+name[i]+":");
                    if(i<=1)
                        s=input.next();
                    else
                        x=input.nextDouble();
                    switch (i) {
                        case 0: food.setFoodName(s);break;
                        case 1: food.setFoodExplain(s);break;
                        case 2: food.setFoodPrice(x);break;
                        default:break;
                    }
                }
                i++;
            }
            int k=foodDao.updateFood(food);
            if(k!=0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }else {
            System.out.println("该商店无此食品");
        }
    }

    @Override
    public void removeFood(Integer businessId) {
        System.out.print("输入你要删除的食物id:");
        int foodId=input.nextInt();
        Food food=foodDao.getFoodById(foodId);
        if(food!=null&&food.getBusinessId().equals(businessId)) {
            int k = foodDao.removeFood(foodId);
            if (k == 0) {
                System.out.println("删除失败");
            } else {
                System.out.println("删除成功");
            }
        }else{
            System.out.println("该商店无此食品");
        }
    }
}
