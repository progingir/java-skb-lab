package com.example.demo.dto;

import java.util.List;

public record TodoListResponseDto(
        Long id,
        String name,
        List<String> events
) {}
