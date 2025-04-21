package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public/api")
public class PublicApiController {

    @GetMapping
    public String publicAccess() {
        return "This is public API accessible to everyone";
    }
}