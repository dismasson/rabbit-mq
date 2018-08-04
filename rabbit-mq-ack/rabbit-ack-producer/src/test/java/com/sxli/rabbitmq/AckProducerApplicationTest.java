package com.sxli.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AckProducerApplication.class)
public class AckProducerApplicationTest {

    @Autowired
    private Producer log;

    @Test
    public void contextLoads() {
        log.info("用户进入系统");
        log.error("系统出现异常");
    }
}
