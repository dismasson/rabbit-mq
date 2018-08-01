package com.sxli.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendPersistence(Object msg) {
        System.out.println("持久化队列:" + msg);
        rabbitTemplate.convertAndSend("persistence.exchange", "persistence.routing", msg);
    }

    public void sendNotPersistence(Object msg) {
        System.out.println("非持久化队列:" + msg);
        rabbitTemplate.convertAndSend("not.persistence.exchange", "not.persistence.routing", msg);
    }
}
