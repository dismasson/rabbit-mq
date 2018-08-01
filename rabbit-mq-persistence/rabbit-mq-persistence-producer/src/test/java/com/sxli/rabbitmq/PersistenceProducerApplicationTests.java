package com.sxli.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PersistenceProducerApplication.class)
public class PersistenceProducerApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(2000);
            producer.sendPersistence(i);
            producer.sendNotPersistence(i);
        }
    }

}
