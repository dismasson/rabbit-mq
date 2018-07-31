package com.sxli.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TopicProducerApplication.class)
public class TopicProducerApplicationTest {

	@Autowired
	private UserSender userSender;
	@Autowired
	private OrderSender orderSender;
	@Autowired
	private ProductSender productSender;

	@Test
	public void contextLoads() {
		userSender.info();
		userSender.error();
		userSender.debug();
		userSender.warn();
		orderSender.info();
		orderSender.error();
		orderSender.debug();
		orderSender.warn();
		productSender.info();
		productSender.error();
		productSender.debug();
		productSender.warn();
	}
}
