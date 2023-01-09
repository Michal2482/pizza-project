package com.example.pizzaproject.controller.administration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/{prefix}")
public class AdministrationController {

    @GetMapping("/admin")
    public String getAdmin(@PathVariable String prefix) {
        return "admin/administration";
    }
}
