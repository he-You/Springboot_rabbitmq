package com.heyou.springboot.rabbitmq.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author heyou
 * @date 2019-11-07 17:55
 */
@Component
//设置监听的队列
@RabbitListener(queues = "queue1")
public class MessageReceiver {

    @RabbitHandler
    public void process(String msg, Channel channel, Message message) throws IOException {

        try {
            Thread.sleep(3000);
            System.out.println("睡眠3s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //通知服务器，已经收到该消息，并且已经消费了，可以删除该队列，否则消息服务器后续还会继续发送消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
        }
    }
}
