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

    @RequestMapping("/boot/send2")
    public String send2(){
        msgSender.send("exchange2","");
        return "success";
    }

    @RequestMapping("/boot/send3")
    public String send3(){
        //#:匹配多个单词，*匹配一个单词
        msgSender.send("exchange3","abc.k.a.b");
        return "success";
    }
}
