package com.example.kzassettwoslices.service.impl;

import com.example.kzassettwoslices.model.OrderItem;
import com.example.kzassettwoslices.repository.OrderItemRepository;
import com.example.kzassettwoslices.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getOrderItemById(Long orderItemId) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);
        return optionalOrderItem.orElse(null);
    }

    @Override
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(Long orderItemId, OrderItem updatedOrderItem) {
        Optional<OrderItem> optionalOrderItem = orderItemRepository.findById(orderItemId);
        if (optionalOrderItem.isPresent()) {
            updatedOrderItem.setOrderItemId(orderItemId);
            return orderItemRepository.save(updatedOrderItem);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}