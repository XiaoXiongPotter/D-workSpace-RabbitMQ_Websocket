package com.example.demo.web;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Jsonclass {

	
	 @Autowired
	 private AmqpTemplate rabbitTemplate;
	@GetMapping("/test")
	public String contextLoads() {
		

       String context = "此消息在，配置转发消息模式队列下， 有 TopicReceiver1 TopicReceiver2 TopicReceiver3 可以收到";

       String routeKey = "closedPlace";

       String exchange = "topicExchange";

       context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

       System.out.println("sendMessageTest : " + context);
       this.rabbitTemplate.convertAndSend(exchange, routeKey, context);
       return "yes";
	}
}
