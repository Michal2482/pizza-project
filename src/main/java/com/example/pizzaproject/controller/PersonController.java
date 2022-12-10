package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Person;
import com.example.pizzaproject.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/addPerson")                     //wyświetlanie widoku formularza dodawania cat.
    public String getPerson() {
        return "persons/addPerson";
    }

    @PostMapping("/addPerson")                            //dodaje kategorię do bazy i przekierowuje
    public RedirectView postAddCategory(Person person) {   //na formularz dodawania
        personService.addPerson(person);
        return new RedirectView("/addPerson");
    }
}
