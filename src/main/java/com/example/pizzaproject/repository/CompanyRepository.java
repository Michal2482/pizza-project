package com.example.pizzaproject.repository;

import com.example.pizzaproject.model.BasicInformation;
import com.example.pizzaproject.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findCompanyByPrefix(String prefix);
}
