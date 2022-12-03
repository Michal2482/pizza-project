package com.example.pizzaproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BasicInformationController {

    @GetMapping("/admin/basicInformation")
    public String getBasicInformationForm() {
        return "admin/basicInformation";
    }

    @PostMapping("/admin/basicInformation")
    public RedirectView postEditBasicInformation
}
