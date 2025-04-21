package com.example.demo.beans;

import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnExpression("#{'${EXAMPLE_TEST:default}' != 'default'}")
@Log4j2
public class EnvBean {
    @PostConstruct
    public void init() {
        log.info("EnvBean created");
    }
}