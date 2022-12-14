package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Category;
import com.example.pizzaproject.model.DescriptionOnPages;
import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.service.CategoryService;
import com.example.pizzaproject.service.DescriptionOnPagesService;
import com.example.pizzaproject.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/{prefix}")
public class MenuController {

    private final MealService mealService;
    private final DescriptionOnPagesService descriptionOnPagesService;

    public MenuController(MealService mealService, DescriptionOnPagesService descriptionOnPagesService, CategoryService categoryService) {
        this.mealService = mealService;
        this.descriptionOnPagesService = descriptionOnPagesService;
        this.categoryService = categoryService;
    }

    private final CategoryService categoryService;

    @GetMapping ("/menu")
    public String getMealList(Model model, @PathVariable String prefix) {                //wyświetla widok menu z listą dań i kategorii
        List<Meal> mealList = mealService.getMeals();
        model.addAttribute("meal", mealList);
        DescriptionOnPages descriptionOnPages = descriptionOnPagesService.getInformation(prefix);
        model.addAttribute("descriptionOnPages", descriptionOnPages);
        List<Category> categoryList = categoryService.getCategories(prefix);
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
}
