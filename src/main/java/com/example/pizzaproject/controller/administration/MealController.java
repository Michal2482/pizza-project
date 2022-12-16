package com.example.pizzaproject.controller.administration;

import com.example.pizzaproject.model.Category;
import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.service.CategoryService;
import com.example.pizzaproject.service.MealService;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/{prefix}")
public class MealController {
    private final MealService mealService;
    private final CategoryService categoryService;

    public MealController(MealService mealService, CategoryService categoryService) {
        this.mealService = mealService;
        this.categoryService = categoryService;
    }

    @GetMapping("/addDish")                                 //wyświetla widok formularza do dodawania
    public String getAddDish(Model model, @PathVariable String prefix) {                     //dodany model do arg. by przekazać do widoku
        List<Category> categoryList = categoryService.getCategories(prefix);  //przekazanie kategorii do widoku
        model.addAttribute("category", categoryList);
        return "meals/addMeal";
    }

    @GetMapping("/editDish/{id}")                                //wyświetla widok formularza edytowanego dania
    public String getEdi2tDish(@PathVariable("id") Long id, Model model, @PathVariable String prefix) {
        Meal meal = mealService.getMeal(id);
        model.addAttribute("meal", meal);
        List<Category> categoryList = categoryService.getCategories(prefix);  //przekazanie kategorii do widoku
        model.addAttribute("category", categoryList);
        return "meals/editMeal";
    }

//    @PostMapping("/addDish")                          //dodawanie dania
//    public RedirectView postAddMeal(Meal meal, @RequestParam Long categoryId) {
//        mealService.addMeal(meal, categoryId);
//        return new RedirectView("/addDish");
//    }
    @PostMapping("/addDish")                          //dodawanie dania
    public RedirectView postAddMeal(Meal meal, @PathVariable String prefix, @RequestParam("file") MultipartFile file) {
        mealService.store(file);
        mealService.addMeal(meal, prefix, file.getOriginalFilename());
        return new RedirectView("/{prefix}/admin");
    }

    @GetMapping("/mealList")                           //wyświetla widok z listą dań pod edycję
    public String getMealList(Model model, @PathVariable String prefix) {
        List<Meal> mealList = mealService.getMeals(prefix);
        model.addAttribute("meal", mealList);
        return "meals/mealList";
    }

    @PostMapping("/editDish/{id}")                       //zapisuje edytowane danie
    public RedirectView postEditMeal(Meal editedMeal, @PathVariable("id")Long id,
                                     @PathVariable String prefix, @RequestParam(name = "file", required = false) MultipartFile file) {
        mealService.editMeal(editedMeal,prefix, file);
        return new RedirectView("/{prefix}/mealList");          //przekierowuje na widok listy do edycji

    }

    @PostMapping("deleteDish/{id}")
    public RedirectView deleteMeal(@PathVariable("id")Long id, @PathVariable String prefix) {
        mealService.deleteMeal(id);
        return new RedirectView("/{prefix}/mealList");
    }

    @GetMapping(value = "/meal/{id}/image")
    @ResponseBody
    public Resource getImageForAdvert(@PathVariable Long id){
        return mealService.loadAsResourceByMealId(id);
    }

}
