package com.example.demo.config;

import com.example.demo.service.DependentBean;
import com.example.demo.service.EnvironmentBean;
import com.example.demo.service.TestProfileBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConditionalConfig {

    @Value("${example.test:default}")
    private String exampleTestValue;

    @Bean
    @Profile("test")
    public TestProfileBean testProfileBean() {
        return new TestProfileBean();
    }

    @Bean
    @Profile("test") // Добавляем условие, чтобы dependentBean создавался только в профиле test
    @DependsOn("testProfileBean")
    public DependentBean dependentBean() {
        return new DependentBean();
    }

    @Bean
    public EnvironmentBean environmentBean() {
        return !"default".equals(exampleTestValue) ? new EnvironmentBean() : null;
    }
}