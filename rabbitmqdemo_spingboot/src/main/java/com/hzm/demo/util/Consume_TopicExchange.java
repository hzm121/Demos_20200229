package com.hzm.demo.util;

import com.hzm.demo.TestExchangeType.MyConsumer;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : hzm
 * @date : 2020-03-07 13:11
 */
public class Consume_TopicExchange {
    public static void main(String[] args) throws IOException, TimeoutException {
        String userName = "hzm";
        String password = "hzmandlyw";
        String host = "10.211.55.4";
        int port = 5672;
        String vhost = "/testTopicExchange";
        Channel channel = ConnectionFactoryUtil.GetChannel(userName, password, host, port, vhost);

        String exchangeName = "test_topic_exchange";
        String queueName = "test_topic_queue";
        String routingKey = "hzm.*";
        channel.queueDeclare(queueName,true,false,false,null);
        channel.exchangeDeclare(exchangeName, ExchangeTypes.TOPIC);
        channel.queueBind(queueName, exchangeName, routingKey);
        channel.basicConsume(queueName, true, new MyConsumer(channel));

    }
}
