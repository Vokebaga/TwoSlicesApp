package com.example.kzassettwoslices.repository;

import com.example.kzassettwoslices.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}