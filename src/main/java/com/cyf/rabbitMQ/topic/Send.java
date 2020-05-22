package com.cyf.rabbitMQ.topic;

import com.cyf.rabbitMQ.Utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**主题模式 生产者
 * @author by cyf
 * @date 2020/5/21.
 */
public class Send {
    public static final String EXCHANGE_NAME="exchange_topic";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //绑定交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"topic");
        //String routingKey = "goods.create";//key
        String routingKey = "goods.delete";
        //消息
        String msg = "商品";
        channel.basicPublish(EXCHANGE_NAME,routingKey,null,msg.getBytes());
        System.out.println("send:"+msg);

        channel.close();
        connection.close();

    }


}
