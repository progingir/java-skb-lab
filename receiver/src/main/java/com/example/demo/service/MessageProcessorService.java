package com.example.demo.service;

import com.example.demo.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageProcessorService {

    public void processMessage(MessageDto message) {
        log.info("Получено сообщение: {}", message);
    }
}