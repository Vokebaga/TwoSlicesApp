package com.example.kzassettwoslices.controller;

import com.example.kzassettwoslices.model.Dish;
import com.example.kzassettwoslices.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @GetMapping("/{dishId}")
    public Dish getDishById(@PathVariable Long dishId) {
        return dishService.getDishById(dishId);
    }

    @PostMapping
    public Dish createDish(@RequestBody Dish dish) {
        return dishService.createDish(dish);
    }

    @PutMapping("/{dishId}")
    public Dish updateDish(@PathVariable Long dishId, @RequestBody Dish updatedDish) {
        return dishService.updateDish(dishId, updatedDish);
    }

    @DeleteMapping("/{dishId}")
    public void deleteDish(@PathVariable Long dishId) {
        dishService.deleteDish(dishId);
    }
}