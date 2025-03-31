package com.example.demo.dto;

import com.example.demo.validation.ComplexMessageValidation;
import lombok.Data;

@Data
public class MessageRequest {
    @ComplexMessageValidation
    private String message;
}