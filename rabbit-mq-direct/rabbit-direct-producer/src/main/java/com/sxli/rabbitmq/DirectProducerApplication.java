package com.sxli.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class DirectProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DirectProducerApplication.class, args);
	}
}
