package com.sxli.rabbitmq.consumer;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(
                        value = "queue.main",
                        autoDelete = "true",
                        arguments = {
                                @Argument(
                                        name = "x-dead-letter-exchange",
                                        value = "exchange.dlx"
                                ),
                                @Argument(
                                        name = "x-dead-letter-routing-key",
                                        value = "routing.key.reserve"
                                )/*,
                                @Argument(
                                        name = "x-max-length",
                                        value = "100",
                                        type = "java.lang.Integer"
                                )*/
                        }
                ),
                exchange = @Exchange(value = "exchange.log", type = ExchangeTypes.DIRECT),
                key = "${rabbitmq.config.routing.dlx.main}"
        )
)
/**
 * 主力队列消费者，当消息无法被消费时候利用DLX机制将消息推送到备用队列
 */
@Component
public class MainConsumer {
    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("主力消费者接收到消息:" + msg);
        //AMQP.Basic.Reject
        //MessageListener
        throw new RuntimeException("模拟系统异常");
        /*try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
