package com.heyou.springboot.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author heyou
 */
@Configuration
public class RabbitConfig {
    /**
     * 定义直连交换机：精确匹配
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        //创建直连交换机，在rabbitMQ服务器上创建
        return new DirectExchange("exchange1");
    }

    /**
     *
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("exchange2");
    }

    /**
     *
     * @return
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("x3");
    }

    /**
     * 创建队列，用来存放exchange路由过来的消息
     * @return
     */
    @Bean
    public Queue Queue1(){
        //param；durable表示数据是否可以持久化
        Queue queue = new Queue("Queue1",true);
        return queue;
    }
    /**
     *
     * @return
     */
   /* @Bean
    public Queue Q2(){
        Queue queue = new Queue("Q2",true);
        return queue;
    }
    *//**
     *
     * @return
     *//*
    @Bean
    public Queue Q3(){
        Queue queue = new Queue("Q3",true);
        return queue;
    }
    *//**
     *
     * @return
     *//*
    @Bean
    public Queue Q4(){
        Queue queue = new Queue("Q4 ",true);
        return queue;
    }*/

    /**
     * 绑定关系：交换机+队列
     * @param Queue1
     * @param directExchange
     * @return
     */
    @Bean
    public Binding bindingDirectExchange(Queue Queue1,DirectExchange directExchange){
        //with方法中的参数是调用发送消息的方法时指定的路由key
        return BindingBuilder.bind(Queue1).to(directExchange).with("routingkey1");
    }
}
