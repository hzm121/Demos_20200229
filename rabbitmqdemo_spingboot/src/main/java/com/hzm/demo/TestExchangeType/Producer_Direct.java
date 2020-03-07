package com.hzm.demo.TestExchangeType;

import com.hzm.demo.util.ConnectionFactoryUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.ExchangeTypes;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : hzm
 * @date : 2020-03-06 13:03
 */
public class Producer_Direct {
    public static void main(String[] args) throws IOException, TimeoutException {
        String userName = "hzm";
        String password = "hzmandlyw";
        String host = "10.211.55.4";
        int port = 5672;
        String vhost = "/testDirectExchange";
        Channel channel = ConnectionFactoryUtil.GetChannel(userName, password, host, port, vhost);
        String exchangeName = "test_direct_exchange";

        String routingKey = "test001";


        //发送消息
        String msg = "Hello RabbitMq!";
        for (long i = 0; i < 10000; i++) {
            System.out.println(i);
            channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());
        }
        //记得关闭相关连接
        ConnectionFactoryUtil.Close();
    }
}
