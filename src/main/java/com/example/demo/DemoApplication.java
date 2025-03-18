package com.example.demo;

import com.example.demo.service.MessageProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		MessageProcessor processor = context.getBean(MessageProcessor.class);
		processor.processMessages();
		context.close();
	}
}