package com.sxli.rabbitmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "integral.fanout", autoDelete = "true"),
                exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.FANOUT)
        )
)
@Component
public class IntegralConsumer implements IConsumer {
    @Override
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("用户下单，积分系统要负责给账号添加消费积分:" + msg);
    }
}
