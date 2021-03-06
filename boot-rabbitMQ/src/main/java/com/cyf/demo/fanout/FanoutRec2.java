package com.cyf.demo.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author by cyf
 * @date 2020/5/22.
 */
@Component
@RabbitListener(queues = "q_fanout_B")
public class FanoutRec2 {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("BReceiver  : " + hello + "/n");
    }
}
