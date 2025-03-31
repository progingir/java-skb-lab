package com.example.demo.validation;

import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank(message = "Сообщение не может быть пустым")
@Size(min = 5, max = 50, message = "Сообщение должно быть от 5 до 50 символов")
public @interface ComplexMessageValidation {
    String message() default "Неверное сообщение";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}