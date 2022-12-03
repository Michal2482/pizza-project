package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class MealController {
    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/addDish")                                 //wyświetla widok formularza do
    public String getAddDish() {
        return "meals/addMeal";
    }

    @GetMapping("/editDish")                                //wyświetla widok formularza edycji
    public String getEditDish() {
        return "meals/editMeal";
    }

    @GetMapping("/editDish/{id}")                                //wyświetla widok listy do edytowania
    public String getEdi2tDish(@PathVariable("id") Long id, Model model) {
        Meal meal = mealService.getMeal(id);
        model.addAttribute("meal", meal);
        return "meals/editMeal";
    }


    @PostMapping("/addDish")                          //dodawanie dania
    public RedirectView postAddMeal(Meal meal) {
        mealService.addMeal(meal);
        return new RedirectView("/addDish");
    }

    //    @PostMapping("/admin/deleteMeal")                       //usuwanie dania
//    public RedirectView postDeleteMeal(Meal meal) {
//        mealService.deleteMeal(meal);
//        return new RedirectView("admin/administration");
//    }
//    @PostMapping("/getMeals")                         //wyświetlanie dań
//    public RedirectView getMeals(Meal meal) {
//        mealService.getMeals();
//        return new RedirectView("pizzaPage/menu");
//    }
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



}
