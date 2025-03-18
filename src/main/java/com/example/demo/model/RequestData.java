package com.example.demo.model;

import lombok.Data;

@Data
public class RequestData {
    private Double price;
    private Info info;

    @Data
    public static class Info {
        private String date;
    }
}