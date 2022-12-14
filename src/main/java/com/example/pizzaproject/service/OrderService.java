package com.example.pizzaproject.service;


import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.model.Order;
import com.example.pizzaproject.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;

@Service
@SessionScope
public class OrderService {

    private Order order;

    public OrderService() {
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
}
