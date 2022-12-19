package com.example.pizzaproject.service;

import com.example.pizzaproject.model.User;
import com.example.pizzaproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class DbInitializer{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DbInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void addUser(User user) {
        userRepository.save(new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), "PIZZERIA_OWNER"));
    }

}
