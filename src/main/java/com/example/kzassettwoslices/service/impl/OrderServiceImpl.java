package com.example.kzassettwoslices.service.impl;

import com.example.kzassettwoslices.model.Order;
import com.example.kzassettwoslices.model.OrderItem;
import com.example.kzassettwoslices.repository.OrderRepository;
import com.example.kzassettwoslices.service.OrderService;
import com.example.kzassettwoslices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        return optionalOrder.orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        // Вычисляем общую цену заказа
        double totalPrice = calculateTotalPrice(order.getOrderItems(), order.getOrderType());

        // Устанавливаем вычисленную цену заказа
        order.setTotalPrice(totalPrice);

        // Сохраняем заказ в репозиторий
        return orderRepository.save(order);
    }

    private double calculateTotalPrice(List<OrderItem> orderItems, String orderType) {
        double totalPrice = 0.0;

        // Подсчитываем сумму всех блюд в заказе
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getDish().getPrice() * orderItem.getQuantity();
        }

        // Применяем различные наценки или скидки в зависимости от типа заказа
        switch (orderType) {
            case "с самовывозом":
                totalPrice *= 0.9; // скидка 10% для самовывоза
                break;
            case "на месте":
                totalPrice *= 1.1; // наценка 10% для обслуживания на месте
                break;
            case "доставка":
                totalPrice += 5.0; // дополнительные 5$ за доставку
                break;
            // Добавьте другие условия по мере необходимости
            default:
                // Если тип заказа не определен, ничего не изменяем
                break;
        }

        return totalPrice;
    }

    @Override
    public Order updateOrder(Long orderId, Order updatedOrder) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setUser(updatedOrder.getUser());
            order.setTotalPrice(updatedOrder.getTotalPrice());
            order.setStatus(updatedOrder.getStatus());
            order.setDate(updatedOrder.getDate());
            return orderRepository.save(order);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
