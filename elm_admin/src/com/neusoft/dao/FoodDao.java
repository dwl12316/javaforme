package com.neusoft.dao;

import com.neusoft.domain.Food;

import java.util.List;

public interface FoodDao {
    List<Food> listFood(Integer businessId);
    int saveFood(Food food);
    int updateFood(Food food);
    int removeFood(Integer foodId);
    Food getFoodById(Integer foodId);
}
