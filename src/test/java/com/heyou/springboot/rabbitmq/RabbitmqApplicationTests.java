package com.heyou.springboot.rabbitmq;

import com.heyou.springboot.rabbitmq.simple.SimpleSend;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RabbitmqApplicationTests {

    @Resource
    SimpleSend simpleSend;

    @Test
    public void simpleSend() {
        simpleSend.send();
    }

}
