package com.sxli.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqHelloApplication.class)
public class RabbitMqHelloApplicationTests {

	@Autowired
	private Producer producer;

	@Test
	public void contextLoads() {
		producer.send("hello world");
	}

}
