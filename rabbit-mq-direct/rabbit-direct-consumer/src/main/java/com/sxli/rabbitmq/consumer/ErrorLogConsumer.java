package com.sxli.rabbitmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${rabbitmq.config.queue.error}", autoDelete = "true"),
                exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.DIRECT),
                key = "${rabbitmq.config.routing.error}"
        )
)
@Component
public class ErrorLogConsumer implements logConsumer {
    @Override
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("接收到error日志:" + msg);
    }
}
