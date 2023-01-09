package com.example.pizzaproject.repository;

import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {


    List<Meal> findAllByCompanyId(Long id);

    @Query(value = "SELECT m FROM Meals m WHERE m.company.id = :id AND (m.name LIKE %:searchedText% OR m.description LIKE %:searchedText% OR  cast(m.price as string) LIKE %:searchedText%)")
    List<Meal> findAllByCompanyIdAndSearchedText(@Param("id") Long id,@Param("searchedText") String searchedText);
}
