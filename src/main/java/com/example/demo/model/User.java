package com.example.demo.model;

import com.example.demo.validation.ValidUser;
import lombok.Data;

@Data
public class User {
    @ValidUser
    private String username;
}
