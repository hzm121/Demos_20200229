package com.hzm.demo.TestExchangeType;

import com.hzm.demo.util.ConnectionFactoryUtil;
import com.hzm.demo.util.Constant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : hzm
 * @date : 2020-03-07 16:59
 */
public class Producer_Fanout {
    public static void main(String[] args) throws IOException, TimeoutException {


        String exchangeName = "test_fanout_exchange";
        //routing不管怎么写都没事，只要交换机和队列有绑定即可
        String routingKey = "";
        String msg = "hello fanout";
        Channel channel = ConnectionFactoryUtil.GetChannel(Constant.userName, Constant.password, Constant.host, Constant.port, Constant.vhost);
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());
        }
        ConnectionFactoryUtil.Close();
    }
}
