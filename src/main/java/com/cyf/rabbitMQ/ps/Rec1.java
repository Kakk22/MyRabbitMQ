package com.cyf.rabbitMQ.ps;

import com.cyf.rabbitMQ.Utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author by cyf
 * @date 2020/5/21.
 */
public class Rec1 {
    public static final String QUEUE_NAME = "queue_email";
    public static final String EXCHANGE_NAME ="exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        final Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //将队列绑定到交换机
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,"");

        channel.basicQos(1);//保证一次只分发一个
        //消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                String msg = new String(body,"UTF-8");
                System.out.println("[1] Recv:msg"+msg);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("[1] done");
                    //每次消费完 通知队列继续发送
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        //
        Boolean autoAsk = false;//自动应答  false
        channel.basicConsume(QUEUE_NAME,autoAsk,consumer);
    }
}
