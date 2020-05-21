package com.cyf.rabbitMQ.work;

import com.cyf.rabbitMQ.Utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**生产者
 * @author by cyf
 * @date 2020/5/21.
 */
public class Send {
    public static final String QUEUE_NAME = "work_queue";
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        //保证每次发生只发送一条给消费者
        int  prefetchCount = 1;
        channel.basicQos(prefetchCount);
        for (int i = 0; i < 30; i++) {
            String msg = ""+i;
            //发送消息
            channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
            System.out.println("send:msg"+i);
            Thread.sleep(i*20);
        }

        channel.close();
        connection.close();
    }
}
