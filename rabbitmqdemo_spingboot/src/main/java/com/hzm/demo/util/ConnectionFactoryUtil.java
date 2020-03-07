package com.hzm.demo.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author : hzm
 * @date : 2020-03-06 23:25
 */
public class ConnectionFactoryUtil {
    private static Channel channel;
    private static Connection connection;

    public static Channel GetChannel(String userName, String password, String host, int port, String vhost) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(password);
        connectionFactory.setHost(host);
        connectionFactory.setVirtualHost(vhost);
        connectionFactory.setPort(port);
        connection = connectionFactory.newConnection();
        channel = connection.createChannel();
        return channel;
    }

    public static void Close() throws IOException, TimeoutException {
        channel.close();
        connection.close();
    }
}
