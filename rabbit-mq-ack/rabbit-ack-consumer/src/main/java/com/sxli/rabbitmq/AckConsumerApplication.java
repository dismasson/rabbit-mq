package com.sxli.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AckConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AckConsumerApplication.class, args);
	}
}
