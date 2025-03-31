package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RussianNameValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRussianName {
    String message() default "Имя должно начинаться с заглавной буквы и содержать только русские буквы";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
