package com.example.demo.controller;

import com.example.demo.limiter.RequestLimit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class ApiController {

    @GetMapping("/run")
    public String run() {
        return "Hello, World!";
    }
}