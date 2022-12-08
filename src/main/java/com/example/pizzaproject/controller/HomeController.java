package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.service.BasicInformationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{prefix}")
public class HomeController {
    private final BasicInformationService basicInformationService;

    public HomeController(BasicInformationService basicInformationService) {
        this.basicInformationService = basicInformationService;
    }

    @GetMapping
    public String getHome(Model model, @PathVariable String prefix) {
        BasicInformation basicInformation = basicInformationService.getInformation(prefix);
        model.addAttribute("basicInformation", basicInformation);
        return "index";
    }


}



