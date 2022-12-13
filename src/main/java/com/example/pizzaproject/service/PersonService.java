package com.example.pizzaproject.service;

import com.example.pizzaproject.exceptions.PizzaProjectException;
import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.model.Person;
import com.example.pizzaproject.repository.CompanyRepository;
import com.example.pizzaproject.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final CompanyRepository companyRepository;

    public PersonService(PersonRepository personRepository, CompanyRepository companyRepository) {
        this.personRepository = personRepository;
        this.companyRepository = companyRepository;
    }

    public void addPerson(Person person, String prefix) {
        person.setCompany(companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix)));
        personRepository.save(person);
    }

    public List<Person> getPersons(String prefix) {
        Company companyInDatabase = companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix));
        return personRepository.findAllByCompanyId(companyInDatabase.getId());
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public void editPerson(Person person, String prefix) {//do zapisywania edycji
        person.setCompany(companyRepository.findCompanyByPrefix(prefix).orElseThrow(()->new PizzaProjectException(PizzaProjectException.EMPTY_COMPANY_ID+prefix)));
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
