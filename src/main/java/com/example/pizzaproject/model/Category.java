package com.example.pizzaproject.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private Set<Meal> meals = new HashSet<>();

    public Category() {
    }

    public Category(Long id, String categoryName, Set<Meal> meals) {
        this.id = id;
        this.categoryName = categoryName;
        this.meals = meals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }
}
