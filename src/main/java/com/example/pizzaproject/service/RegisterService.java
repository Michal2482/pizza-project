package com.example.pizzaproject.service;

import com.example.pizzaproject.model.Company;
import com.example.pizzaproject.model.User;
import com.example.pizzaproject.repository.CompanyRepository;
import com.example.pizzaproject.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class RegisterService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final CompanyRepository companyRepository;

    public RegisterService(UserRepository userRepository, PasswordEncoder passwordEncoder, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.companyRepository = companyRepository;
    }

    @Transactional
    public void addUser(User user, Company company) {
        userRepository.save(new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), "ROLE_PIZZERIA_OWNER",company));
    }


}
