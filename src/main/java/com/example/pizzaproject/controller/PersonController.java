package com.example.pizzaproject.controller;

import com.example.pizzaproject.model.Person;
import com.example.pizzaproject.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

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


    @GetMapping("/editPerson/{id}")                                //wyświetla widok formularza edytowanej osoby
    public String getEditPerson(@PathVariable("id") Long id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "persons/editPerson";
    }

    @PostMapping("/addPerson")                          //dodawanie zedytowanej osoby do bazy
    public RedirectView postAddPerson(Person person) {
        personService.addPerson(person);
        return new RedirectView("/addPerson");
    }

    @GetMapping("/edit2Person")                           //wyświetla widok z listą dań osób edycję
    public String getPersonList(Model model) {
        List<Person> personList = personService.getPersons();
        model.addAttribute("person", personList);
        return "persons/edit2Person";
    }

    @PostMapping("/addPerson/{id}")                       //zapisuje edytowaną osobę
    public RedirectView postEditPerson(Person editedPerson, @PathVariable("id")Long id) {
        personService.editPerson(editedPerson);
        return new RedirectView("/edit2Person");          //przekierowuje na widok listy do edycji

    }

    @PostMapping("editPerson/{id}")
    public RedirectView deleteMeal(@PathVariable("id")Long id) {
        personService.deletePerson(id);
        return new RedirectView("/edit2Person");
    }
}
