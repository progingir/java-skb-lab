package com.example.demo.dto;

import com.example.demo.validation.ComplexNameValidation;
import lombok.Data;

@Data
public class UserInput {
    @ComplexNameValidation
    private String name;
}