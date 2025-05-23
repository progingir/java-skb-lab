package com.example.demo.dto;

import java.time.Instant;

public record MessageDto(String text, Instant createdAt) {
}
