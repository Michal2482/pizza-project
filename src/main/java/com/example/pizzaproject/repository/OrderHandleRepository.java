package com.example.pizzaproject.repository;


import com.example.pizzaproject.model.OrderHandle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHandleRepository extends JpaRepository<OrderHandle,Long> {
}
