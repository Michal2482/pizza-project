package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Category;
import com.example.pizzaproject.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Locale;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")                      //wyświetlanie widoku listy kategorii
    public String getCategoryList() {
        return "categories/categoryList";
    }

    @GetMapping("/addCategory")                     //wyświetlanie widoku formularza dodawania cat.
    public String getCategory() {
        return "categories/addCategory";
    }

    @PostMapping("/addCategory")                            //dodaje kategorię do bazy i przekierowuje
    public RedirectView postAddCategory(Category category) {   //na formularz dodawania
        categoryService.addCategory(category);
        return new RedirectView("/addCategory");
    }






}
