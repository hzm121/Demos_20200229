package com.hzm.demo;

import com.hzm.demo.util.ConnectionFactoryUtil;
import com.hzm.demo.util.Constant;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author : hzm
 * @date : 2020-03-07 17:41
 */
public class Producer_testMessage {
    public static void main(String[] args) throws IOException, TimeoutException {
        String exchangeName = "test_fanout_exchange2";
        String routingKey = "test001";
        String msg = "hello fanout2";

        Channel channel = ConnectionFactoryUtil.GetChannel(Constant.userName, Constant.password, Constant.host, Constant.port, Constant.vhost);
        Map<String,Object> headers = new HashMap<>();
        headers.put("test1", "1");
        headers.put("test2", "2");
        headers.put("test3", "3");

        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .contentEncoding("UTF-8")
                .deliveryMode(2)
                .expiration("10000")
                .headers(headers)
                .build();

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            channel.basicPublish(exchangeName, routingKey, properties, msg.getBytes());
        }
        //ConnectionFactoryUtil.Close();
    }
}
