package com.sxli.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotPersistenceConsumer {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "not.persistence.queue", autoDelete = "true"),
                    exchange = @Exchange(value = "not.persistence.exchange", type = ExchangeTypes.DIRECT),
                    key = "not.persistence.routing"
            )
    )
    public void receive(String msg) {
        System.out.println("非持久化队列，消费者服务挂掉会丢失消息:" + msg);
    }

}
