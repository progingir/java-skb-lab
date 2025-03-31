package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DependentBean {
    public DependentBean() {
        log.info("Создан бин DependentBean (зависит от TestProfileBean)");
    }
}