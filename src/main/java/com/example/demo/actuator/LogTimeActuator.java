package com.example.demo.actuator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@Endpoint(id = "logtime")
public class LogTimeActuator {

    @ReadOperation(produces = MediaType.TEXT_PLAIN_VALUE)
    public String logTime() {
        String message = "Actuator called at: " + LocalDateTime.now();
        log.info(message);
        return "Time logged";
    }
}