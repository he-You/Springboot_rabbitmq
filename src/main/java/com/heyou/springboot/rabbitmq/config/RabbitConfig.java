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
     * 创建队列，用来存放exchange路由过来的消息
     * @return
     */
    @Bean
    public Queue queue1(){
        //param；durable表示数据是否可以持久化
        return new Queue("Queue1",true);
    }

    /**
     * 绑定关系：交换机+队列
     * @param queue1
     * @param directExchange
     * @return
     */
    @Bean
    public Binding bindingDirectExchange(Queue queue1,DirectExchange directExchange){
        //with方法中的参数是调用发送消息的方法时指定的路由key
        return BindingBuilder.bind(queue1).to(directExchange).with("routingkey1");
    }

    /**
     * 不需要匹配路由的交换机
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
    public Queue queue2(){
        return new Queue("Queue2",true);
    }
    /**
     *
     * @return
     */
    @Bean
    public Queue queue3(){
        return new Queue("Queue3",true);
    }

    /**
     * 绑定关系：fanout交换机+队列1
     * @param queue2
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingFanoutExchange1(Queue queue2,FanoutExchange fanoutExchange){
        //with方法中的参数是调用发送消息的方法时指定的路由key(适用于精确匹配和模糊匹配)
        return BindingBuilder.bind(queue2).to(fanoutExchange);
    }

    /**
     * 绑定关系：fanout交换机+队列2
     * @param queue3
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding bindingFanoutExchange2(Queue queue3,FanoutExchange fanoutExchange){
        //with方法中的参数是调用发送消息的方法时指定的路由key(适用于精确匹配和模糊匹配)
        return BindingBuilder.bind(queue3).to(fanoutExchange);
    }

    /**
     * 创建交换机：进行模糊匹配
     * @return
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("exchange3");
    }

    /**
     *
     * @return
     */
    @Bean
    public Queue queue4() {
        return new Queue("Queue4", true);
    }

    /**
     *
     * @return
     */
    @Bean
    public Queue queue5() {
        return new Queue("Queue5", true);
    }

    /**
     * 绑定关系：topic交换机+队列2
     * @param queue4
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding bindingTopicExchange(Queue queue4,TopicExchange topicExchange){
        //with方法中的参数是调用发送消息的方法时指定的路由key(适用于精确匹配和模糊匹配)
        return BindingBuilder.bind(queue4).to(topicExchange).with("*.k.#");
    }

    /**
     * 绑定关系：topic交换机+队列2
     * @param queue5
     * @param topicExchange
     * @return
     */
    @Bean
    public Binding bindingTopicExchange2(Queue queue5,TopicExchange topicExchange){
        //with方法中的参数是调用发送消息的方法时指定的路由key(适用于精确匹配和模糊匹配)
        return BindingBuilder.bind(queue5).to(topicExchange).with("*.k.*");
    }
}
