package com.example.pizzaproject.controller.auth;

import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.service.RegisterCompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class AuthController {

    private final RegisterCompanyService registerCompanyService;

    public AuthController(RegisterCompanyService registerCompanyService) {
        this.registerCompanyService = registerCompanyService;
    }

    @GetMapping("/login")
    public String getLogin(Model model, @RequestParam(value = "error",required = false) String error,
                           @RequestParam(value = "logout",	required = false) String logout) {

        if (error != null) {
            model.addAttribute("error", "Wrong username or password. Try again");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully. Welcome again");
        }

        return "auth/login";
    }


    @GetMapping("/register")
    public String getRegister() {
        return "auth/register";
    }

    @PostMapping("/register")
    public RedirectView postRegisterCompany(Company company) {
        registerCompanyService.addCompany(company);
        return new RedirectView("/login");
    }

}
