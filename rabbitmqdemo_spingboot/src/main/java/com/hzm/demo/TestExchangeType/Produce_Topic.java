package com.hzm.demo.TestExchangeType;

import com.hzm.demo.util.ConnectionFactoryUtil;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : hzm
 * @date : 2020-03-07 14:16
 */
public class Produce_Topic {
    public static void main(String[] args) throws IOException, TimeoutException {
        String userName = "hzm";
        String password = "hzmandlyw";
        String host = "10.211.55.4";
        int port = 5672;
        String vhost = "/testTopicExchange";
        Channel channel = ConnectionFactoryUtil.GetChannel(userName, password, host, port, vhost);
        String exchangeName = "test_topic_exchange";

        String topic_routingkey1 = "hzm.hello";
        String topic_routingkey2 = "hzm.hello.ww";
        String topic_routingkey3 = "hzm3.hello";



        //发送消息
        String msg1 = "Hello RabbitMq!1";
        String msg2 = "Hello RabbitMq!2";
        String msg3 = "Hello RabbitMq!3";

        for (long i = 0; i < 10; i++) {
            System.out.println(i);
            channel.basicPublish(exchangeName, topic_routingkey1, null, msg1.getBytes());
            channel.basicPublish(exchangeName, topic_routingkey2, null, msg2.getBytes());
            channel.basicPublish(exchangeName, topic_routingkey3, null, msg3.getBytes());

        }
        //记得关闭相关连接
        ConnectionFactoryUtil.Close();
    }
}
