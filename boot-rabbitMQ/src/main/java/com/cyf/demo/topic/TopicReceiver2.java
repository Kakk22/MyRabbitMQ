package com.cyf.demo.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author by cyf
 * @date 2020/5/22.
 */
@Component
@RabbitListener(queues = "q_topic_messages")
public class TopicReceiver2 {

    @RabbitHandler
    public void receiver(String message){
        System.out.println("Receiver2:"+message);
    }
}
