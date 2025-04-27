package com.example.demo.model;

public record ResponseData(Double price, ResponseData.Info info) {

    public record Info(Integer id, String date) {
    }
}