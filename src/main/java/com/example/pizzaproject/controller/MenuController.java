package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Category;
import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.service.CategoryService;
import com.example.pizzaproject.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {

    private final MealService mealService;

    public MenuController(MealService mealService, CategoryService categoryService) {
        this.mealService = mealService;
        this.categoryService = categoryService;
    }

    private final CategoryService categoryService;

    @GetMapping ("/menu")
    public String getMealList(Model model) {                //wyświetla widok menu z listą dań i kategorii
        List<Meal> mealList = mealService.getMeals();
        model.addAttribute("meal", mealList);
        List<Category> categoryList = categoryService.getCategories();
        model.addAttribute("category", categoryList);
        return "pizzaPage/menu";
    }

//    @GetMapping("/menu")
//    public String getAbout() {
//        return "pizzaPage/menu";
//    }



}
