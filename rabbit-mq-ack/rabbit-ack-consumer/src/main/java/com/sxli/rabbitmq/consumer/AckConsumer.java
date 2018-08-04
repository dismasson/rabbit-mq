package com.sxli.rabbitmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "queue.ack", autoDelete = "true"),
                exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.DIRECT),
                key = "${rabbitmq.config.routing.ack}"
        )
)
@Component
public class AckConsumer {
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("Ack:" + msg);
    }
}
