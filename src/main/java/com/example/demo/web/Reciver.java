package com.example.demo.web;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="closedPlace")
public class Reciver {

	@RabbitHandler
	public void process(String message) {
        System.out.println("接收者 TopicReceiver1," + message);
    }
}
