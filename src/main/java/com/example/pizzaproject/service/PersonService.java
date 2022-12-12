package com.example.pizzaproject.service;

import com.example.pizzaproject.model.Meal;
import com.example.pizzaproject.model.Person;
import com.example.pizzaproject.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> getPersons() {                          //pobiera wszystkie osoby, korzysta z niej
        return personRepository.findAll();
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public void editPerson(Person person) {                       //do zapisywania edycji
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
        System.out.println("Deleting personon id " + id);

    }
}
