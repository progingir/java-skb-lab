package com.example.demo.controller;

import com.example.demo.model.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserController {
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok("Пользователь создан: " + user.getUsername());
    }
}
