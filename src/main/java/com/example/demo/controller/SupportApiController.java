package com.example.demo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/support/api")
public class SupportApiController {

    @GetMapping
    @RolesAllowed("SUPPORT")
    public String supportAccess(Principal principal) {
        return String.format("Support API accessed by: %s (role: SUPPORT)", principal.getName());
    }
}