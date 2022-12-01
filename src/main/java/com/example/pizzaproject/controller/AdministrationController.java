package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.service.MealService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AdministrationController {



    @GetMapping("/admin")                                   //wyświetlanie strony
    public String getAdmin() {
        return "admin/administration";
    }

}
