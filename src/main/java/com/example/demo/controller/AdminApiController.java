package com.example.demo.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/admin/api")
public class AdminApiController {

    @GetMapping
    @RolesAllowed("ADMIN")
    public String adminAccess(Principal principal) {
        return String.format("Admin API accessed by: %s (role: ADMIN)", principal.getName());
    }
}
