package com.hzm.demo.TestExchangeType;

import com.rabbitmq.client.*;
import com.rabbitmq

        .client.impl.nio.BlockingQueueNioQueue;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @author : hzm
 * @date : 2020-03-06 13:03
 */
public class MyConsumer extends  DefaultConsumer{
    /**
     * Constructs a new instance and records its association to the passed-in channel.
     *
     * @param channel the channel to which this consumer is attached
     */
    public MyConsumer(Channel channel) {
        super(channel);
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        System.out.println(properties.getHeaders());
        System.err.println(properties.getDeliveryMode());
        System.err.println(Thread.currentThread().getName());
        System.err.println("body"+new String(body));
    }


}
