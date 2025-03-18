package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {
    private static final Logger logger = LoggerFactory.getLogger(MessageProcessor.class);

    @Autowired
    private MessageService emailService;

    private final MessageService smsService;

    private MessageService anotherService;

    @Autowired
    public MessageProcessor(MessageService smsService) {
        this.smsService = smsService;
    }

    @Autowired
    public void setAnotherService(MessageService anotherService) {
        this.anotherService = anotherService;
    }

    public void processMessages() {
        logger.info("Processing messages:");
        logger.info("Email service: " + emailService.getMessage());
        logger.info("SMS service: " + smsService.getMessage());
        logger.info("Another service: " + anotherService.getMessage());
    }
}
