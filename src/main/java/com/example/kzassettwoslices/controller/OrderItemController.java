package com.example.kzassettwoslices.controller;

import com.example.kzassettwoslices.model.OrderItem;
import com.example.kzassettwoslices.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderItems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{orderItemId}")
    public OrderItem getOrderItemById(@PathVariable Long orderItemId) {
        return orderItemService.getOrderItemById(orderItemId);
    }

    @PostMapping
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }

    @PutMapping("/{orderItemId}")
    public OrderItem updateOrderItem(@PathVariable Long orderItemId, @RequestBody OrderItem updatedOrderItem) {
        return orderItemService.updateOrderItem(orderItemId, updatedOrderItem);
    }

    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}