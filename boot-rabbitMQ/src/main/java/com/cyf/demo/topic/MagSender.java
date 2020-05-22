package com.cyf.demo.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author by cyf
 * @date 2020/5/22.
 */
@Component
public class MagSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void Send1(){
        String message = "hello,i am message1";
        System.out.println("send:"+message);
        rabbitTemplate.convertAndSend("topicExchange","topic.message",message);
    }

    public void Send2(){
        String message = "hello,i am message2";
        System.out.println("send:"+message);
        rabbitTemplate.convertAndSend("topicExchange","topic.messages",message);
    }
}
