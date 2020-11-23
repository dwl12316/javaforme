package com.neusoft;

import com.neusoft.domain.Business;
import com.neusoft.view.BusinessView;
import com.neusoft.view.FoodView;
import com.neusoft.view.Impl.BusinessViewImpl;
import com.neusoft.view.Impl.FoodViewImpl;

import java.util.Scanner;

public class BusinessAdminEntry {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        Scanner input = new Scanner(System.in);
        System.out.println("----------------------------------------------");
        System.out.println("-------------欢迎进入饿了么商家管理系统------------");
        System.out.println("----------------------------------------------");
        BusinessView businessView=new BusinessViewImpl();
        Business business=businessView.login();
        if(business!=null){
            int businessId=business.getBusinessId();
            System.out.println("商家"+business.getBusinessName()+"欢迎你进入");
            int meau=0;
            while (meau!=5){
                System.out.println("---------------");
                System.out.println("1. 查看商家信息");
                System.out.println("2. 修改商家信息");
                System.out.println("3. 修改密码");
                System.out.println("4. 所属商品管理");
                System.out.println("5. 退出系统");
                System.out.println("---------------");
                System.out.print("输入你的选择:");
                meau=input.nextInt();
                switch (meau){
                    case 1:
                        businessView.outBusinessbyId(businessId);
                        break;
                    case 2:
                        businessView.updateBusiness(business);
                        break;
                    case 3:
                        businessView.updatePassword(businessId);
                        break;
                    case 4:
                        foodManager(businessId);
                        break;
                    case 5:
                        System.out.println("欢迎下次进入");
                        break;
                    default:
                        System.out.println("没有这个选项");
                        break;
                }
            }
        }else {
            System.out.println("登录失败");
        }
    }
    public static void foodManager(Integer businessId){
        int meau=0;
        Scanner input =new Scanner(System.in);
        FoodView foodView=new FoodViewImpl();
        while (meau!=5) {
            System.out.println("---------------");
            System.out.println("1. 查看食品信息");
            System.out.println("2. 修改食品信息");
            System.out.println("3. 增加食品信息");
            System.out.println("4. 删除食品信息");
            System.out.println("5. 退出二级系统");
            System.out.println("---------------");
            System.out.print("输入你的选择:");
            meau=input.nextInt();
            switch (meau){
                case 1:
                    foodView.showFoodList(businessId);
                    break;
                case 2:
                    foodView.updateFood(businessId);
                    break;
                case 3:
                    foodView.saveFood(businessId);
                    break;
                case 4:
                    foodView.removeFood(businessId);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("没有这个选项");
                    break;
            }
        }
    }
}
