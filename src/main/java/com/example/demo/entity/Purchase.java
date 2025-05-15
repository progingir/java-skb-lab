package com.example.demo.entity;

import lombok.Data;

@Data
public class Purchase {
    private Long id;
    private Chocolate chocolate;
    private int quantity;

    public Purchase(Chocolate chocolate, int quantity) {
        this.chocolate = chocolate;
        this.quantity = quantity;
    }
}