package com.example.demo.controllers;

import com.example.demo.model.RequestData;
import com.example.demo.model.ResponseData;
import com.example.demo.service.JsonProcessingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    private final JsonProcessingService service;

    public JsonController(JsonProcessingService service) {
        this.service = service;
    }

    @PostMapping("/process")
    public ResponseData processJson(@RequestBody RequestData requestData) {
        return service.process(requestData);
    }
}