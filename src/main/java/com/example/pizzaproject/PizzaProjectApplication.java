package com.example.pizzaproject;

import com.example.pizzaproject.config.StorageProperties;
import com.example.pizzaproject.service.AdvertService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class PizzaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner init(AdvertService advertService) {
        return (args) -> {
            advertService.deleteAll();
            advertService.init();
        };
    }

}
