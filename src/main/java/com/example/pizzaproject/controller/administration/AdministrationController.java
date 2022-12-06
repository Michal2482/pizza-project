package com.example.pizzaproject.controller.administration;

import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.service.BasicInformationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdministrationController {
    @GetMapping("/admin")
    public String getAdmin() {
        return "admin/administration";
    }



}
