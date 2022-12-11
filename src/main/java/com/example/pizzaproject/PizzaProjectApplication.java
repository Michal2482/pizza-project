package com.example.pizzaproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class PizzaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaProjectApplication.class, args);
    }

}
