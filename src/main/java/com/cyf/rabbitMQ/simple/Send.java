package com.cyf.rabbitMQ.simple;

import com.cyf.rabbitMQ.Utils.ConnectionUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**生产者
 * @author by cyf
 * @date 2020/5/20.
 */
public class Send {

    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "hello queue";
        System.out.println("message:"+message);
        //消息传入
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());

        channel.close();
        connection.close();
    }
}
