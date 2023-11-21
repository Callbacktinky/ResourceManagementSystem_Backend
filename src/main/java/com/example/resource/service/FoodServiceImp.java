package com.example.resource.service;

import com.example.resource.Exception.ResourceNotFoundException;
import com.example.resource.Model.Food;
import com.example.resource.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Component
@Service
public class FoodServiceImp implements FoodService{
    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    public FoodServiceImp(FoodRepository foodRepository) {
        super();
        this.foodRepository = foodRepository;
    }


    @Override
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public List<Food> getAllFoodDetails() {
        return foodRepository.findAll();
    }

    @Override
    public Food getFoodDetailsById(long id) {
        return foodRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Food", "Id", id));
    }

    @Override
    public Food updateFoodDetails(Food food, long id) {
        Food existingFood = foodRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Food", "Id", id));
        existingFood.setId(food.getId());
        existingFood.setItem(food.getItem());
        existingFood.setDrink(food.getDrink());
        existingFood.setQuantity(food.getQuantity());

        foodRepository.save(existingFood);
        return existingFood;
    }

    @Override
    public void deleteFoodDetails(long id) {
        foodRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Food", "Id", id));
        foodRepository.deleteById(id);
    }
}
