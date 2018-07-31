package com.sxli.rabbitmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "log.info", autoDelete = "true"),
                exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.TOPIC),
                key = "*.log.info"
        )
)
@Component
public class InfoConsumer implements logConsumer {
    @Override
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("info logs:" + msg);
    }
}
