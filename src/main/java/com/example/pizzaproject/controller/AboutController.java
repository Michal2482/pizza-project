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
public class AboutController {
    private final DescriptionOnPagesService descriptionOnPagesService;
    private final BasicInformationService basicInformationService;

    public AboutController(DescriptionOnPagesService descriptionOnPagesService, BasicInformationService basicInformationService) {
        this.descriptionOnPagesService = descriptionOnPagesService;
        this.basicInformationService = basicInformationService;
    }

    @GetMapping("/about")
    public String getAbout(@PathVariable String prefix, Model model) {
        DescriptionOnPages descriptionOnPages =descriptionOnPagesService.getInformation(prefix);
        model.addAttribute("descriptionOnPages",descriptionOnPages);
        BasicInformation basicInformation = basicInformationService.getInformation(prefix);
        model.addAttribute("basicInformation",basicInformation);
        return "pizzaPage/about";
    }
}
