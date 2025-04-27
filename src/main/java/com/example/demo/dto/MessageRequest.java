package com.example.demo.dto;

import com.example.demo.validation.ComplexMessageValidation;

public record MessageRequest(
        @ComplexMessageValidation
        String message
) {
}