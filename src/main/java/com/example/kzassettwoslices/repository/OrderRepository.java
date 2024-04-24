package com.example.kzassettwoslices.repository;

import com.example.kzassettwoslices.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}