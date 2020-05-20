package com.cyf.rabbitMQ.Utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**rabbitMQ ConnectionUtil
 * @author by cyf
 * @date 2020/5/20.
 */
public class ConnectionUtil {

    public static  Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        //设置账号密码  端口号 主机地址
        factory.setUsername("cyf");
        factory.setPassword("123");
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/mqtest");
        Connection connection = factory.newConnection();

        return connection;
    }
}
