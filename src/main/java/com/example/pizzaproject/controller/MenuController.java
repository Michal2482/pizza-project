package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Category;
import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.service.CategoryService;
import com.example.pizzaproject.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class MenuController {

    private final MealService mealService;

    public MenuController(MealService mealService, CategoryService categoryService) {
        this.mealService = mealService;
        this.categoryService = categoryService;
    }

    private final CategoryService categoryService;

    @GetMapping("/menu")
    public String getMealList(Model model) {                //wyświetla widok menu z listą dań i kategorii
        List<Meal> mealList = mealService.getMeals();
        model.addAttribute("meal", mealList);
        List<Category> categoryList = categoryService.getCategories();
        Map<String, List<Meal>> mealByCategories = mealList.stream().collect(Collectors.toMap(
                meal -> meal.getCategory().getCategoryName(),
                meal -> List.of(meal),
                (List<Meal> oldVal, List<Meal> newVal) -> {
                    List<Meal> newList = new ArrayList();
                    newList.addAll(oldVal);
                    newList.addAll(newVal);
                    return newList;
                }
        ));
        model.addAttribute("category", categoryList);
        model.addAttribute("categoryMap", mealByCategories);
        return "pizzaPage/menu";
    }

//    @GetMapping("/menu")
//    public String getAbout() {
//        return "pizzaPage/menu";
//    }


}
