package com.example.kzassettwoslices.repository;

import com.example.kzassettwoslices.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}