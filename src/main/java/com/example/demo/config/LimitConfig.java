package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "request.limiter")
@Getter
@Setter
public class LimitConfig {
    private long maxRequests;
    private long timeWindowSeconds;
}