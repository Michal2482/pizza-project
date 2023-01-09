package com.example.pizzaproject.validation;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = FileValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD,ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidImage {
    String message() default "Wrong sufix in stored file";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

