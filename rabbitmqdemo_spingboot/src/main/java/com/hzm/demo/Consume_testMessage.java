package com.hzm.demo;

import com.hzm.demo.TestExchangeType.MyConsumer;
import com.hzm.demo.util.ConnectionFactoryUtil;
import com.hzm.demo.util.Constant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : hzm
 * @date : 2020-03-07 17:50
 */
public class Consume_testMessage {
    public static void main(String[] args) throws IOException, TimeoutException {
        String queueName = "test_fanout_queue2";
        String exchangeName = "test_fanout_exchange";
        String routingKey = "test001";
        Channel channel = ConnectionFactoryUtil.GetChannel(Constant.userName, Constant.password, Constant.host, Constant.port, Constant.vhost);
//        channel.queueDeclare(queueName,true,false,false,null);
//        channel.exchangeDeclare(exchangeName, ExchangeTypes.FANOUT);
//        channel.queueBind(queueName, exchangeName,routingKey);
        channel.basicConsume(queueName, false, new MyConsumer(channel));

    }
}
