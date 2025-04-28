package com.example.demo.limiter;

import com.example.demo.config.LimitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RequestStore {
    private final List<Instant> requestTimes = new ArrayList<>();
    private final LimitConfig config;

    public synchronized void saveRequest() {
        requestTimes.add(Instant.now());
    }

    public synchronized boolean isRequestAllowed() {
        Instant cutoff = Instant.now().minusSeconds(config.getTimeWindowSeconds());

        // Удаляем устаревшие запросы
        requestTimes.removeIf(time -> time.isBefore(cutoff));

        return requestTimes.size() < config.getMaxRequests();
    }
}