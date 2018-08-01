package com.sxli.rabbitmq.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "erp.fanout", autoDelete = "true"),
                exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.FANOUT)
        )
)
@Component
public class ErpConsumer implements IConsumer {
    @Override
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("用户下单，ERP系统要记录用户订单信息:" + msg);
    }
}
