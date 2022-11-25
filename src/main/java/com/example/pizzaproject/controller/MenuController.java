package com.example.pizzaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/menu")
    public String getAbout() {
        return "pizzaPage/menu";
    }
}
