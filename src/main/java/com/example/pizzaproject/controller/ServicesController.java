package com.example.pizzaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{prefix}")
public class ServicesController {

    @GetMapping("/services")
    public String getServices(@PathVariable String prefix) {
        return "pizzaPage/services";
    }
}
