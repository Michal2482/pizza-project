package com.example.pizzaproject.controller.administration;

import com.example.pizzaproject.model.Person;
import com.example.pizzaproject.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/{prefix}")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/addPerson")                     //wyświetlanie widoku formularza dodawania cat.
    public String getPerson(@PathVariable String prefix) {
        return "persons/addPerson";
    }


    @GetMapping("/editPerson/{id}")                                //wyświetla widok formularza edytowanej osoby
    public String getEditPerson(@PathVariable("id") Long id, Model model, @PathVariable String prefix) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "persons/editPerson";
    }

    @PostMapping("/addPerson")                          //dodawanie zedytowanej osoby do bazy
    public RedirectView postAddPerson(Person person, @PathVariable String prefix) {
        personService.addPerson(person,prefix);
        return new RedirectView("/{prefix}/admin");
    }

    @GetMapping("/personList")                           //wyświetla widok z listą dań osób edycję
    public String getPersonList(Model model, @PathVariable String prefix) {
        List<Person> personList = personService.getPersons(prefix);
        model.addAttribute("person", personList);
        return "persons/personList";
    }

    @PostMapping("/editPerson/{id}")                       //zapisuje edytowaną osobę
    public RedirectView postEditPerson(Person editedPerson, @PathVariable("id") Long id, @PathVariable String prefix) {
        personService.editPerson(editedPerson, prefix);
        return new RedirectView("/{prefix}/personList");          //przekierowuje na widok listy do edycji

    }

    @PostMapping("/deletePerson/{id}")
    public RedirectView deleteMeal(@PathVariable("id")Long id, @PathVariable String prefix) {
        personService.deletePerson(id);
        return new RedirectView("/{prefix}/personList");
    }
}
