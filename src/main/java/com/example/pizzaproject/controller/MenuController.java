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
import org.springframework.web.bind.annotation.RequestParam;

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
        List<Meal> mealList = mealService.getMeals(prefix);
        model.addAttribute("meal", mealList);
        List<Category> categoryList = categoryService.getCategories(prefix);
        Map<String, List<Meal>> mealByCategories =mealService.mealByCategories(mealList);
        model.addAttribute("category", categoryList);
        model.addAttribute("categoryMap", mealByCategories);
        DescriptionOnPages descriptionOnPages = descriptionOnPagesService.getInformation(prefix);
        model.addAttribute("descriptionOnPages", descriptionOnPages);
        return "pizzaPage/menu";
    }

    @GetMapping(value = "/menu/search")
    public String getSearchedMealList(Model model, @PathVariable String prefix, @RequestParam("freeText") String freeText) {
        List<Meal> mealListWithSearchedText = mealService.getMealsWithSearchedText(prefix,freeText);
        model.addAttribute("mealBeforeSearch", mealListWithSearchedText);

        DescriptionOnPages descriptionOnPages = descriptionOnPagesService.getInformation(prefix);
        model.addAttribute("descriptionOnPages", descriptionOnPages);

        return "pizzaPage/menu";
    }
}
