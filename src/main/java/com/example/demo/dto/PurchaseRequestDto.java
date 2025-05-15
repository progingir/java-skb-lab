package com.example.demo.dto;

import com.example.demo.entity.Chocolate;

public record PurchaseRequestDto(Chocolate chocolate, int quantity) {
}