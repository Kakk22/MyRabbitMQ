package com.cyf.demo.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author by cyf
 * @date 2020/5/22.
 */
@Component
@RabbitListener(queues = "q_hello")
public class Receiver {

    @RabbitHandler
    public void process(String message){
        System.out.println(message);
    }
}
