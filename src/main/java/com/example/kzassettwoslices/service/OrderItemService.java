package com.example.kzassettwoslices.service;

import com.example.kzassettwoslices.model.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();

    OrderItem getOrderItemById(Long orderItemId);

    OrderItem createOrderItem(OrderItem orderItem);

    OrderItem updateOrderItem(Long orderItemId, OrderItem updatedOrderItem);

    void deleteOrderItem(Long orderItemId);
}