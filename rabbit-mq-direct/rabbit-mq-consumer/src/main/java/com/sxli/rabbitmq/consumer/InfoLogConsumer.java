package com.sxli.rabbitmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${rabbitmq.config.queue.info}", autoDelete = "true"),
                exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.DIRECT),
                key = "${rabbitmq.config.routing.info}"
        )
)
@Component
public class InfoLogConsumer implements logConsumer {
    @Override
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("接收到info日志:" + msg);
    }
}
