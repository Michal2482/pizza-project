package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    private final MealService mealService;

    public MenuController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping ("/menu/getMeals")
    public String getMealList(Model model) {
        List<Meal> mealList = mealService.getMeals();
        model.addAttribute("meal", mealList);
        return "pizzaPage/menu";
    }

    @GetMapping("/menu")
    public String getAbout() {
        return "pizzaPage/menu";
    }



}
