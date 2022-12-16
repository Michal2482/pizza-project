package com.example.pizzaproject.service;


import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.model.Order;
import com.example.pizzaproject.model.OrderStatus;
import com.example.pizzaproject.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@SessionScope
public class OrderService {
    private OrderRepository orderRepository;
    private Order order;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        clear();
    }

    public Order getOrder() {
        return order;
    }

    public void add(Meal meal) {
        order.getOrderedMeal().add(meal);
    }

    public void clear() {
        order = new Order();
        order.setStatus(OrderStatus.NEW);
    }

    public BigDecimal totalPrice() {
    return getOrder().getOrderedMeal().stream()
            .map(meal -> meal.getPrice())
            .reduce(BigDecimal.valueOf(0),(currentSum, streamElement)->currentSum.add(streamElement));
    }

    public Order postOrderToRealize(String address, String telephone) {
        order.setAddress(address);
        order.setTelephone(telephone);
        orderRepository.save(order);
        clear();
        return order;
    }

    public List<Order> getOrders() {
        return orderRepository.findAllByStatus(OrderStatus.NEW);
    }
@Transactional
    public void changeOrderStatusDone(Long id) {
        Order order2 = orderRepository.findById(id).orElse(null);
        order2.setStatus(OrderStatus.COMPLETE);
    }
}
