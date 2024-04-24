package com.example.kzassettwoslices.service.impl;

import com.example.kzassettwoslices.model.Dish;
import com.example.kzassettwoslices.repository.DishRepository;
import com.example.kzassettwoslices.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish getDishById(Long dishId) {
        Optional<Dish> optionalDish = dishRepository.findById(dishId);
        return optionalDish.orElse(null);
    }

    @Override
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish updateDish(Long dishId, Dish updatedDish) {
        Optional<Dish> optionalDish = dishRepository.findById(dishId);
        if (optionalDish.isPresent()) {
            Dish dish = optionalDish.get();
            dish.setName(updatedDish.getName());
            dish.setDescription(updatedDish.getDescription());
            dish.setPrice(updatedDish.getPrice());
            dish.setCategory(updatedDish.getCategory());
            return dishRepository.save(dish);
        } else {
            return null;
        }
    }

    @Override
    public void deleteDish(Long dishId) {
        dishRepository.deleteById(dishId);
    }
}