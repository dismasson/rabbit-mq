package com.sxli.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PersistenceConsumer {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "persistence.queue", autoDelete = "false"),
                    exchange = @Exchange(value = "persistence.exchange", type = ExchangeTypes.DIRECT),
                    key = "persistence.routing"
            )
    )
    public void receive(String msg) {
        System.out.println("持久化队列，消费者服务挂掉不会丢失消息:" + msg);
    }

}
