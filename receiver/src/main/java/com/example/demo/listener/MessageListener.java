package com.example.demo.listener;

import com.example.demo.dto.MessageDto;
import com.example.demo.service.MessageProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageListener {

    private final MessageProcessorService messageProcessorService;

    @KafkaListener(
            topics = "${app.kafka.consumer.message.topic}",
            groupId = "${app.kafka.consumer.message.group-id}"
    )
    public void listen(MessageDto message) {
        messageProcessorService.processMessage(message);
    }
}