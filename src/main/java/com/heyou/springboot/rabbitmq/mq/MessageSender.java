package com.heyou.springboot.rabbitmq.mq;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 发送消息的服务类
 * @author heyou
 */
@Component
public class MessageSender implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(String exchange,String routingKey){
        String context ="现在是"+new Date();
        System.out.println("send content="+context);
        this.rabbitTemplate.setMandatory(true);
        this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.setReturnCallback(this);
        //发送消息（params:交换机，路由，消息内容）
        this.rabbitTemplate.convertAndSend(exchange,routingKey,context);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {

    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {

    }
}
