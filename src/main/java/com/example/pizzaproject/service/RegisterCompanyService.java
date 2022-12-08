package com.example.pizzaproject.service;


import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterCompanyService {

    private final CompanyRepository companyRepository;

    public RegisterCompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    public String getPrefixCompanyById(Long id) {
        return companyRepository.findById(id).stream().map(company -> company.getPrefix()).findAny().orElse(null);
    }
}
