package com.example.pizzaproject.controller.auth;

import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.service.RegisterCompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class AuthController {

    private final RegisterCompanyService registerCompanyService;

    public AuthController(RegisterCompanyService registerCompanyService) {
        this.registerCompanyService = registerCompanyService;
    }

    @GetMapping("/login")
    public String getLogin() {
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

    @PostMapping("/login")
    public RedirectView postLoginCompany(Long id, Model model) {
        String prefix =registerCompanyService.getPrefixCompanyById(id);
//        model.addAttribute("prefix",prefix);
        System.out.println(prefix);
        return new RedirectView("/"+prefix);
    }
}
