package com.cyf.demo.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by cyf
 * @date 2020/5/22.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("q_hello");
    }
}
