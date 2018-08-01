package com.sxli.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class PersistenceProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersistenceProducerApplication.class, args);
    }
}
