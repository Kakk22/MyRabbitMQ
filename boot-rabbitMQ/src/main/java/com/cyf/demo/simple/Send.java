package com.cyf.demo.simple;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author by cyf
 * @date 2020/5/22.
 */
@Component
public class Send {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send()  {
        String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String msg = "hello rabbit" +data;
        System.out.println("Send:"+msg);
        //简单对列的情况下routingKey即为Q名
        rabbitTemplate.convertAndSend("q_hello",msg);

    }

}
