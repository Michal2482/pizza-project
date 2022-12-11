package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Person;
import com.example.pizzaproject.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AboutController {
    private final PersonService personService;

    public AboutController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/about")
    public String getAbout(Model model) {
        List<Person> personList = personService.getPersons();
        model.addAttribute("person", personList);
        return "pizzaPage/about";
    }
}
