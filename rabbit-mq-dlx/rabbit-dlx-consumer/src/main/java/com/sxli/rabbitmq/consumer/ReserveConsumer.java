package com.sxli.rabbitmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "queue.reserve", autoDelete = "true"),
                exchange = @Exchange(value = "exchange.dlx", type = ExchangeTypes.DIRECT),
                key = "routing.key.reserve"
        )
)
@Component
/**
 * 备用队列消费者，当主力队列无法消费消息的时候将该消息推送到备用队列
 */
public class ReserveConsumer {
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("备用队列接收到主力队列无法消费的消息:" + msg);
    }
}
