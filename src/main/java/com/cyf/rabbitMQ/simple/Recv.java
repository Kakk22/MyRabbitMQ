package com.cyf.rabbitMQ.simple;

import com.cyf.rabbitMQ.Utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**消费者
 * @author by cyf
 * @date 2020/5/20.
 */
public class Recv {
    private static final String QUEUE_NAME = "test_simple_queue";


    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String smg = new String(body,"utf-8");
                System.out.println(new Date());
                System.out.println("recv:" + smg);
            }
        };

        channel.basicConsume(QUEUE_NAME,defaultConsumer);
    }




    public static void oldApi(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
       //创建消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //监听队列
        channel.basicConsume(QUEUE_NAME,consumer);
        //获得消息
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            byte[] bytes = delivery.getBody();
            String msgString = new String (bytes);
            System.out.println("recv:message"+msgString);
        }
    }
}
