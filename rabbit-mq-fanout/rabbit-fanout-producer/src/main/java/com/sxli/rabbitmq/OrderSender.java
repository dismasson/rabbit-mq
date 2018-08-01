package com.sxli.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.config.exchange}")
    private String exchange;

    public void push() {
        rabbitTemplate.convertAndSend(this.exchange, "", "用户下单啦。。。");
    }
}
