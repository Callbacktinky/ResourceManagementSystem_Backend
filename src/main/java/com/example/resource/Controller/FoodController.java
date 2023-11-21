package com.example.resource.Controller;

import com.example.resource.Model.Food;
import com.example.resource.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        super();
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<Food> saveFood(@RequestBody Food food){
        return new ResponseEntity<Food>(foodService.saveFood(food), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Food> getAllFoodDetails() {
        return foodService.getAllFoodDetails();
    }

    @GetMapping("{id}")
    public ResponseEntity<Food> getFoodDetailsById(@PathVariable("id") long foodId){
        return new ResponseEntity<Food>(foodService.getFoodDetailsById(foodId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Food> updateFoodDetails(@PathVariable("id") long id
            ,@RequestBody Food food){
        return new ResponseEntity<>(foodService.updateFoodDetails(food, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFoodDetails(@PathVariable("id") long id){
        foodService.deleteFoodDetails(id);
        return new ResponseEntity<>("Food Details Deleted Successfully!", HttpStatus.OK);
    }
}
