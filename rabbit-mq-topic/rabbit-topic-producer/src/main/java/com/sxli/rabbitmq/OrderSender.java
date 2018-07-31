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

    @Value("${rabbitmq.config.routing.info}")
    private String routingInfo;

    @Value("${rabbitmq.config.routing.error}")
    private String routingError;

    @Value("${rabbitmq.config.routing.debug}")
    private String routingDebug;

    @Value("${rabbitmq.config.routing.warn}")
    private String routingWarn;

    public void info() {
        rabbitTemplate.convertAndSend(this.exchange, this.routingInfo, "order.log.info...");
    }

    public void error() {
        rabbitTemplate.convertAndSend(this.exchange, this.routingError, "order.log.error...");
    }

    public void debug() {
        rabbitTemplate.convertAndSend(this.exchange, this.routingDebug, "order.log.debug...");
    }

    public void warn() {
        rabbitTemplate.convertAndSend(this.exchange, this.routingWarn, "order.log.warn...");
    }
}
