package com.example.demo.config;

import com.example.demo.service.MessageService;
import com.example.demo.service.EmailService;
import com.example.demo.service.SMSService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    @Bean
    @Primary
    public MessageService emailService() {
        return new EmailService();
    }

    @Bean
    public MessageService smsService() {
        return new SMSService();
    }
}