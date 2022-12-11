package com.example.pizzaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{prefix}")
public class AboutController {

    @GetMapping("/about")
    public String getAbout(@PathVariable String prefix) {
        return "pizzaPage/about";
    }
}
