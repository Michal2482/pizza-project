package com.example.pizzaproject.repository;

import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {


    List<Meal> findAllByCompanyId(Long id);
}
