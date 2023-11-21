package com.example.resource.service;

import com.example.resource.Model.Food;

import java.util.List;

public interface FoodService {
    Food saveFood(Food food);
    List<Food> getAllFoodDetails();
    Food getFoodDetailsById(long id);
    Food updateFoodDetails(Food food, long id);
    void deleteFoodDetails(long id);
}
