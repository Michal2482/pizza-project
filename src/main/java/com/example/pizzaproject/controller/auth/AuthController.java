package com.example.pizzaproject.controller.auth;

import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.model.User;
import com.example.pizzaproject.service.CustomUserDetailsService;
import com.example.pizzaproject.service.RegisterService;
import com.example.pizzaproject.service.RegisterCompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class AuthController {

    private final RegisterCompanyService registerCompanyService;
    private final CustomUserDetailsService customUserDetailsService;

    private final RegisterService registerService;

    public AuthController(RegisterCompanyService registerCompanyService, CustomUserDetailsService customUserDetailsService, RegisterService registerService) {
        this.registerCompanyService = registerCompanyService;
        this.customUserDetailsService = customUserDetailsService;
        this.registerService = registerService;
    }

    @GetMapping("/login")
    public String getLogin(Model model, @RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout) {
        if (error != null) {
            model.addAttribute("error", "Wrong username or password. Try again");}
        if (logout != null) {
            model.addAttribute("message", "Logged out successfully. Welcome again");}
        return "auth/login";
    }


    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("user",new User());
        return "auth/register";
    }

    @PostMapping("/register")
    public RedirectView postRegisterUser(@Valid User user, Company company) {
        registerCompanyService.addCompany(company);
        registerService.addUser(user,company);
        return new RedirectView("/login");
    }

}
