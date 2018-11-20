package com.gofers.requestserver.message;

import java.util.Date;

import com.gofers.requestserver.bean.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fangzongzhou
 */
@Component
public class Sender {

	Logger logger = LoggerFactory.getLogger(Sender.class);

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hello " + new Date();
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("hello", context);
	}

	public void sendRequest(Request request) {
		logger.info(request.toString());
		rabbitTemplate.convertAndSend("request", request);
	}

}