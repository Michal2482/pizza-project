package com.example.pizzaproject.controller.administration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdministrationController {

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin/administration";
    }



}
