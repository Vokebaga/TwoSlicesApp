package com.example.kzassettwoslices.service;

import com.example.kzassettwoslices.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order getOrderById(Long orderId);

    Order createOrder(Order order);

    Order updateOrder(Long orderId, Order updatedOrder);

    void deleteOrder(Long orderId);
}