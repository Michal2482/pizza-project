package com.example.pizzaproject.service;


import com.example.pizzaproject.repository.OrderHandleRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderHandleService {

    private final OrderHandleRepository orderHandleRepository;

    public OrderHandleService(OrderHandleRepository orderHandleRepository) {
        this.orderHandleRepository = orderHandleRepository;
    }
}
