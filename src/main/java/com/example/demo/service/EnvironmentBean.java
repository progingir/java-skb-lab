package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnvironmentBean {
    public EnvironmentBean() {
        log.info("Создан бин EnvironmentBean (example.test не default)");
    }
}