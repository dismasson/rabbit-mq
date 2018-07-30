package com.sxli.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.config.exchange}")
    private String exchange;

    @Value("${rabbitmq.config.routing.info}")
    private String infoRoutting;

    @Value("${rabbitmq.config.routing.error}")
    private String errorRoutting;

    public void info(String msg) {
        rabbitTemplate.convertAndSend(this.exchange,this.infoRoutting, msg);
    }

    public void error(String msg) {
        rabbitTemplate.convertAndSend(this.exchange,this.errorRoutting, msg);
    }
}
