package com.cyf.rabbitMQ.ps;

import com.cyf.rabbitMQ.Utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**生产者 订阅
 * @author by cyf
 * @date 2020/5/21.
 */
public class Send {
    public static final String EXCHANGE_NAME="exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        //绑定交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        //消息
        String msg = "hello ps!";
        channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes());
        System.out.println("send:"+msg);

        channel.close();
        connection.close();

    }

}
