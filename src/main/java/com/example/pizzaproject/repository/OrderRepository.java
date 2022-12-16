package com.example.pizzaproject.repository;


import com.example.pizzaproject.model.Order;
import com.example.pizzaproject.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByStatus(OrderStatus status);
}
