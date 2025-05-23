package com.example.demo.service;

import com.example.demo.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageSenderService {

    @Value("${app.kafka.producer.message.topic}")
    private String messageTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String text) {
        var message = new MessageDto(text, Instant.now());
        kafkaTemplate.send(messageTopic, message)
                .thenRun(() -> log.info("Сообщение отправлено в топик: {}", messageTopic))
                .exceptionally(ex -> {
                    log.error("Ошибка при отправке сообщения: {}", ex.getMessage());
                    return null;
                });
    }
}