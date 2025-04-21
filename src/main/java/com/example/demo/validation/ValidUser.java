package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotNull(message = "Имя пользователя не может быть null")
@Size(min = 3, max = 20, message = "Имя пользователя должно быть от 3 до 20 символов")
@Constraint(validatedBy = {})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUser {
    String message() default "Некорректное имя пользователя";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
