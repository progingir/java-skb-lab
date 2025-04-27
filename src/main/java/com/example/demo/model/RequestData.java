package com.example.demo.model;

public record RequestData(Double price, RequestData.Info info) {

    public record Info(String date) {
    }
}