package com.example.demo.controller;

import com.example.demo.dto.MessageRequest;
import com.example.demo.dto.MessageResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    @PostMapping("/message")
    public MessageResponse processMessage(@Valid @RequestBody MessageRequest request) {
        return new MessageResponse("Сообщение принято: " + request.message());
    }
}