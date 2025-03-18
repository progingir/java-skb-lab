package com.example.demo.model;

import lombok.Data;

@Data
public class ResponseData {
    private Double price;
    private Info info = new Info();

    @Data
    public static class Info {
        private Integer id;
        private String date;
    }
}