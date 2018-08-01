package com.sxli.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {

    @RabbitListener(queues = "rabbit-mq-hello")
    public void receive(String msg) {
        System.out.println("receive2:" + msg);
    }

}
