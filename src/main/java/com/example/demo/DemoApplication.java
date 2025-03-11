package com.example.demo;

import com.example.demo.service.MessageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		MessageProcessor processor = context.getBean(MessageProcessor.class);
		processor.processMessages();
	}
}
