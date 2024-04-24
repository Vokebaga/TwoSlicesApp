package com.example.kzassettwoslices.service;

import com.example.kzassettwoslices.model.Dish;

import java.util.List;

public interface DishService {

    List<Dish> getAllDishes();

    Dish getDishById(Long dishId);

    Dish createDish(Dish dish);

    Dish updateDish(Long dishId, Dish updatedDish);

    void deleteDish(Long dishId);
}