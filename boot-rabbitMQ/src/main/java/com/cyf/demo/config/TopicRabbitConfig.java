package com.cyf.demo.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author by cyf
 * @date 2020/5/22.
 */
@Configuration
public class TopicRabbitConfig {
    public static final String MESSAGE = "q_topic_message";
    public static final String MESSAGES = "q_topic_messages";
    //创建队列
    @Bean
    public Queue queueMessage(){
        return new Queue(MESSAGE);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(MESSAGES);
    }
    //声明topic交换机
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }
    //将队列绑定到交换机，并指定routingkey
    @Bean
    public Binding  bingExchangeMessage(Queue queueMessage,TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    @Bean
    public Binding  bingExchangeMessages(Queue queueMessages,TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
