package com.example.pizzaproject.controller.administration;

import com.example.pizzaproject.model.Advert;
import com.example.pizzaproject.service.AdvertService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{prefix}")
public class AdvertController {

    private final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping("/admin/advert")
    public String getAdvertForm(Model model, @PathVariable String prefix) {
        Advert advert = advertService.getInformation(prefix);
        model.addAttribute("advert", advert);
        return "admin/advert";
    }
}
