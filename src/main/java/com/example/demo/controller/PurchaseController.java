package com.example.demo.controller;

import com.example.demo.dto.PurchaseRequestDto;
import com.example.demo.dto.PurchaseResponseDto;
import com.example.demo.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping
    public PurchaseResponseDto createPurchase(@RequestBody PurchaseRequestDto request) {
        return purchaseService.createPurchase(request);
    }

    @GetMapping
    public List<PurchaseResponseDto> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }
}