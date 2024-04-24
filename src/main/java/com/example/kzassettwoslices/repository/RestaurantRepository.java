package com.example.kzassettwoslices.repository;

import com.example.kzassettwoslices.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}