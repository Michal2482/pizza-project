package com.example.pizzaproject.controller.administration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{prefix}")
public class AdministrationController {

    @GetMapping("/admin")
    public String getAdmin(@PathVariable String prefix) {
        return "admin/administration";
    }

}
