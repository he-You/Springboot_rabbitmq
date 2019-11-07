package com.heyou.springboot.rabbitmq.controller;

import com.heyou.springboot.rabbitmq.mq.MessageSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author heyou
 */
@RestController
public class MessageController {
    @Resource
    private MessageSender msgSender;

    /**
     * 正常发送消息
     * @return
     */
    @RequestMapping("/boot/send")
    public String send(){
        msgSender.send("exchange1","routingkey1");
        return "success";
    }
}
