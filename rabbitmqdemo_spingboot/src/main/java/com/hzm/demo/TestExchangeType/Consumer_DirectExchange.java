package com.hzm.demo.TestExchangeType;

import com.hzm.demo.util.ConnectionFactoryUtil;
import com.rabbitmq.client.*;
import org.springframework.amqp.core.ExchangeTypes;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : hzm
 * @date : 2020-03-06 22:20
 */
public class Consumer_DirectExchange {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        String userName = "hzm";
        String password = "hzmandlyw";
        String host = "10.211.55.4";
        int port = 5672;
        String vhost = "/testDirectExchange";
        Channel channel = ConnectionFactoryUtil.GetChannel(userName, password, host, port, vhost);

        String exchangeName = "test_direct_exchange";
        String queueName = "test_direct_queue";
        String routingKey = "test001";

        //声明一个交换器
        channel.exchangeDeclare(exchangeName, ExchangeTypes.DIRECT);
        //声明一个队列
        channel.queueDeclare(queueName, true, false, false, null);
        //把队列和路由器绑定
        channel.queueBind(queueName, exchangeName, routingKey);

        MyConsumer consumer = new MyConsumer(channel);
        //6.消费消息
        channel.basicConsume(queueName, true, consumer);


    }
}
