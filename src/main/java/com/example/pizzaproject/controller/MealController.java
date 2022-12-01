package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MealController {
    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/addDish")
    public String getAddDish() {
        return "meals/addMeal";
    }

    @GetMapping("/editDish")
    public String getEditDish() {
        return "meals/editMeal";
    }


//    @PostMapping("/admin/addMeal")                          //dodawanie dania
//    public RedirectView postAddMeal(Meal meal) {
//        mealService.addMeal(meal);
//        return new RedirectView("/admin");
//    }
//    @PostMapping("/admin/deleteMeal")                       //usuwanie dania
//    public RedirectView postDeleteMeal(Meal meal) {
//        mealService.deleteMeal(meal);
//        return new RedirectView("admin/administration");
//    }
//    @PostMapping("/admin/getMeals")                         //wyświetlanie dań
//    public RedirectView getMeals(Meal meal) {
//        mealService.getMeals();
//        return new RedirectView("admin/administration");
//    }
}
