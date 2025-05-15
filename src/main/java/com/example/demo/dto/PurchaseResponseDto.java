package com.example.demo.dto;

import com.example.demo.entity.Chocolate;

public record PurchaseResponseDto(long id, Chocolate chocolate, int quantity) {
}
