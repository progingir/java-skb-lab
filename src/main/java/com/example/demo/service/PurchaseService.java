package com.example.demo.service;

import com.example.demo.dto.PurchaseRequestDto;
import com.example.demo.dto.PurchaseResponseDto;
import com.example.demo.entity.Purchase;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PurchaseService {

    private final List<Purchase> purchases = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong idGenerator = new AtomicLong();
    private final MeterRegistry meterRegistry;

    public PurchaseService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public PurchaseResponseDto createPurchase(PurchaseRequestDto request) {
        Purchase purchase = new Purchase(request.chocolate(), request.quantity());
        purchase.setId(idGenerator.incrementAndGet());
        purchases.add(purchase);
        // Публикуем метрику о покупке
        meterRegistry.counter("app.purchases." + request.chocolate().name().toLowerCase())
                .increment(request.quantity());
        return new PurchaseResponseDto(purchase.getId(), purchase.getChocolate(), purchase.getQuantity());
    }

    public List<PurchaseResponseDto> getAllPurchases() {
        return purchases.stream()
                .map(p -> new PurchaseResponseDto(p.getId(), p.getChocolate(), p.getQuantity()))
                .toList();
    }
}