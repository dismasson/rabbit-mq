package com.sxli.rabbitmq.consumer;

@FunctionalInterface
public interface IConsumer {

    /**
     * 收集日志方法
     *
     * @param msg 日志内容
     */
    void receiver(String msg);

}
