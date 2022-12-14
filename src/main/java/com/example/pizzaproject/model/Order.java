package com.example.pizzaproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "client_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String address;
    private String telephone;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private BigDecimal price;
    private BigDecimal sum;
    private String delivery;

    @ManyToMany
    @JoinTable(name = "order_meal",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id", referencedColumnName = "id")
    )
    private List<Meal> orderedMeal = new ArrayList<>();
}
