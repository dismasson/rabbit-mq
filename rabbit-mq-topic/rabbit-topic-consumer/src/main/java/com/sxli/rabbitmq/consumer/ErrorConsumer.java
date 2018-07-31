package com.sxli.rabbitmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "log.error", autoDelete = "true"),
                exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.TOPIC),
                key = "*.log.error"
        )
)
@Component
public class ErrorConsumer implements logConsumer {
    @Override
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("error logs:" + msg);
    }
}
