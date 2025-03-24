package com.example.demo.config;

import com.example.demo.service.EmailService;
import com.example.demo.service.SMSService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public EmailService emailService() {
        return new EmailService();
    }

    @Bean
    public SMSService smsService() { // Имя метода и тип совпадают
        return new SMSService();
    }
}