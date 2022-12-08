package com.example.pizzaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{prefix}")
public class ContactController {

    @GetMapping("/contact")
    public String getContact(@PathVariable String prefix) {
        return "pizzaPage/contact";
    }
}
