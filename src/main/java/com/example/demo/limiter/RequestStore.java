package com.example.demo.limiter;

import com.example.demo.config.LimitConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
@RequiredArgsConstructor
public class RequestStore {
    private final ConcurrentMap<String, List<Instant>> requestTimes = new ConcurrentHashMap<>();
    private final LimitConfig config;

    public void saveRequest(String key) {
        List<Instant> times = requestTimes.computeIfAbsent(key, k -> new ArrayList<>());
        synchronized (times) {
            times.add(Instant.now());
        }
    }

    public boolean isRequestAllowed(String key) {
        List<Instant> times = requestTimes.computeIfAbsent(key, k -> new ArrayList<>());
        Instant cutoff = Instant.now().minusSeconds(config.getTimeWindowSeconds());

        synchronized (times) {
            times.removeIf(time -> time.isBefore(cutoff));
            return times.size() < config.getMaxRequests();
        }
    }
}