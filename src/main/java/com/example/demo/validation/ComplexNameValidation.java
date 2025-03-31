package com.example.demo.validation;

import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank(message = "Имя не может быть пустым")
@Size(min = 2, max = 20, message = "Имя должно быть от 2 до 20 символов")
public @interface ComplexNameValidation {
    String message() default "Неверное имя";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}