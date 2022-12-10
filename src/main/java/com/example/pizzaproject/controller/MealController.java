package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Category;
import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.service.CategoryService;
import com.example.pizzaproject.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class MealController {
    private final MealService mealService;
    private final CategoryService categoryService;

    public MealController(MealService mealService, CategoryService categoryService) {
        this.mealService = mealService;
        this.categoryService = categoryService;
    }

    @GetMapping("/addDish")                                 //wyświetla widok formularza do dodawania
    public String getAddDish(Model model) {                     //dodany model do arg. by przekazać do widoku
        List<Category> categoryList = categoryService.getCategories();  //przekazanie kategorii do widoku
        model.addAttribute("category", categoryList);
        return "meals/addMeal";
    }

    @GetMapping("/editDish/{id}")                                //wyświetla widok formularza edytowanego dania
    public String getEdi2tDish(@PathVariable("id") Long id, Model model) {
        Meal meal = mealService.getMeal(id);
        model.addAttribute("meal", meal);
        List<Category> categoryList = categoryService.getCategories();  //przekazanie kategorii do widoku
        model.addAttribute("category", categoryList);
        return "meals/editMeal";
    }

//    @PostMapping("/addDish")                          //dodawanie dania
//    public RedirectView postAddMeal(Meal meal, @RequestParam Long categoryId) {
//        mealService.addMeal(meal, categoryId);
//        return new RedirectView("/addDish");
//    }
    @PostMapping("/addDish")                          //dodawanie dania
    public RedirectView postAddMeal(Meal meal) {
        mealService.addMeal(meal);
        return new RedirectView("/addDish");
    }

    @GetMapping("/edit2Dish")                           //wyświetla widok z listą dań pod edycję
    public String getMealList(Model model) {
        List<Meal> mealList = mealService.getMeals();
        model.addAttribute("meal", mealList);
        return "meals/edit2Meal";
    }

    @PostMapping("/addDish/{id}")                       //zapisuje edytowane danie
    public RedirectView postEditMeal(Meal editedMeal, @PathVariable("id")Long id) {
        mealService.editMeal(editedMeal);
        return new RedirectView("/edit2Dish");          //przekierowuje na widok listy do edycji

    }

    @PostMapping("editDish/{id}")
    public RedirectView deleteMeal(@PathVariable("id")Long id) {
        mealService.deleteMeal(id);
        return new RedirectView("/edit2Dish");
    }



}
