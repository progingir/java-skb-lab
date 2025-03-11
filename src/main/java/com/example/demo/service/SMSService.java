package com.example.demo.service;

import com.example.demo.service.MessageService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SMSService implements MessageService {
    private static final Logger logger = LoggerFactory.getLogger(SMSService.class);

    @PostConstruct
    public void init() {
        logger.info("SMSService bean created");
    }

    @PreDestroy
    public void destroy() {
        logger.info("SMSService bean destroyed");
    }

    @Override
    public String getMessage() {
        return "SMS message";
    }
}
