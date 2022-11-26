package com.example.pizzaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministrationController {

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin/administration";
    }
}
