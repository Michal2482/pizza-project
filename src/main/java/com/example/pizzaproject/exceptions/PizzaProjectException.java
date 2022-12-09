package com.example.pizzaproject.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaProjectException extends RuntimeException {

    public static final String EMPTY_COMPANY_ID = "Don't have company with prefix: ";

    private String message;

    public PizzaProjectException(String message) {
        this.message = message;
    }
}
