package com.cyf.demo;

import com.cyf.demo.simple.Send;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Send sender;

    @Test
    void helloSimple() {
        sender.send();
    }

}
