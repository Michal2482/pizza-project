package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.model.DescriptionOnPages;
import com.example.pizzaproject.service.BasicInformationService;
import com.example.pizzaproject.service.DescriptionOnPagesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{prefix}")
public class HomeController {
    private final BasicInformationService basicInformationService;
    private final DescriptionOnPagesService descriptionOnPagesService;

    public HomeController(BasicInformationService basicInformationService, DescriptionOnPagesService descriptionOnPagesService) {
        this.basicInformationService = basicInformationService;
        this.descriptionOnPagesService = descriptionOnPagesService;
    }

    @GetMapping
    public String getHome(Model model, @PathVariable String prefix) {
        BasicInformation basicInformation = basicInformationService.getInformation(prefix);
        model.addAttribute("basicInformation", basicInformation);
        DescriptionOnPages descriptionOnPages = descriptionOnPagesService.getInformation(prefix);
        model.addAttribute("descriptionOnPages",descriptionOnPages);
        return "index";
    }


}



