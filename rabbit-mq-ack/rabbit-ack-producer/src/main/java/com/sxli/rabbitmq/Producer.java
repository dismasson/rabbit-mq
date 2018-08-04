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

    @Value("${rabbitmq.config.routing.ack}")
    private String ackRouting;

    @Value("${rabbitmq.config.routing.noack}")
    private String noAckRouting;

    public void info(String msg) {
        rabbitTemplate.convertAndSend(this.exchange,this.ackRouting, msg);
    }

    public void error(String msg) {
        rabbitTemplate.convertAndSend(this.exchange,this.noAckRouting, msg);
    }
}
