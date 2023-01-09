package com.example.pizzaproject.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class FileValidator implements ConstraintValidator<ValidImage, MultipartFile> {

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
            if (file == null || file.isEmpty()) {
                return true;
            }
            String fileName = file.getOriginalFilename();
            return fileName.endsWith(".jpg") || fileName.endsWith(".png");
        }

    }
