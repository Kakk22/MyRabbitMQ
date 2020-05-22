package com.cyf.demo;

import com.cyf.demo.simple.Send;
import com.cyf.demo.topic.MagSender;
import com.cyf.demo.work.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Send sender;
    @Autowired
    private Sender workSender;
    @Autowired
    private MagSender magSender;
    @Test
    void helloSimple() {
        sender.send();
    }

    @Test
    void workQueue() throws InterruptedException {

        for (int i = 0; i <50 ; i++) {
            workSender.send(i);
            Thread.sleep(200);
        }
    }
    @Test
    void topicQueue(){
        magSender.Send1();
        magSender.Send2();
    }
}
