package com.example.pizzaproject.service;

import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public void addMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public List<Meal> getMeals() {                          //pobiera wszystkie dania, korzysta z niej
        return mealRepository.findAll();                    //met. getMealList w MenuControllerze
    }

    public Meal getMeal(Long id) {
        return mealRepository.findById(id).orElse(null);
    }

    public void editMeal(Meal meal) {                       //do zapisywania edycji
        mealRepository.save(meal);
    }

    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
        System.out.println("Deleting meal on id " + id);

    }


}
