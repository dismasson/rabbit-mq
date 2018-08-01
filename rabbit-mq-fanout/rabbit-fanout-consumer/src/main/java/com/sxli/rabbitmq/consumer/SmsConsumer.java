package com.sxli.rabbitmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "sms.fanout", autoDelete = "true"),
                exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.FANOUT)
        )
)
@Component
public class SmsConsumer implements IConsumer {
    @Override
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("用户下单，短信服务负责发送短信通知用户:" + msg);
    }
}
