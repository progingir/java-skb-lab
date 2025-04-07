package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record TodoListDto(
        @NotBlank(message = "Name cannot be blank")
        String name,
        @NotEmpty(message = "Events cannot be empty")
        List<String> events
) {}