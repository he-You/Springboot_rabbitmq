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
//设置监听的队列,程序启动就会加载
public class MessageReceiver {
    @RabbitListener(queues = "Queue1")
    @RabbitHandler
    public void process1(String msg, Channel channel, Message message) throws IOException {

        try {
            Thread.sleep(3000);
            System.out.println("睡眠3s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //通知服务器，已经收到该消息，并且已经消费了，可以删除该队列，否则消息服务器后续还会继续发送消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("接受成功："+msg);
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
            System.out.println("接收失败");
        }
    }
    @RabbitListener(queues = "Queue2")
    @RabbitHandler
    public void process2(String msg, Channel channel, Message message) throws IOException {

        try {
            Thread.sleep(3000);
            System.out.println("睡眠3s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //通知服务器，已经收到该消息，并且已经消费了，可以删除该队列，否则消息服务器后续还会继续发送消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("接收者2，接受成功："+msg);
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
            System.out.println("接收失败");
        }
    }

    @RabbitHandler
    @RabbitListener(queues = "Queue3")
    public void process3(String msg, Channel channel, Message message) throws IOException {

        try {
            Thread.sleep(3000);
            System.out.println("睡眠3s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //通知服务器，已经收到该消息，并且已经消费了，可以删除该队列，否则消息服务器后续还会继续发送消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("接收者3，接受成功："+msg);
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
            System.out.println("接收失败");
        }
    }

    @RabbitHandler
    @RabbitListener(queues = "Queue4")
    public void process4(String msg, Channel channel, Message message) throws IOException {

        try {
            Thread.sleep(3000);
            System.out.println("睡眠3s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //通知服务器，已经收到该消息，并且已经消费了，可以删除该队列，否则消息服务器后续还会继续发送消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("接收者4，接受成功："+msg);
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
            System.out.println("接收失败");
        }
    }

    @RabbitHandler
    @RabbitListener(queues = "Queue5")
    public void process5(String msg, Channel channel, Message message) throws IOException {

        try {
            Thread.sleep(3000);
            System.out.println("睡眠5s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            //通知服务器，已经收到该消息，并且已经消费了，可以删除该队列，否则消息服务器后续还会继续发送消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("接收者5，接受成功："+msg);
        } catch (IOException e) {
            e.printStackTrace();
            //丢弃这条消息
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
            System.out.println("接收失败");
        }
    }

}
