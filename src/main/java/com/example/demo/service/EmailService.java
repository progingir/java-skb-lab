package com.example.demo.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @PostConstruct
    public void init() {
        logger.info("EmailService bean created");
    }

    @PreDestroy
    public void destroy() {
        logger.info("EmailService bean destroyed");
    }

    @Override
    public String getMessage() {
        return "Email message";
    }
}
