package com.sxli.rabbitmqhello;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "rabbit-mq-hello")
    public void receive(String msg) {
        System.out.println("receive:" + msg);
    }

}
