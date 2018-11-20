package com.gofers.requestserver.message;

import com.gofers.requestserver.bean.Request;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMethod;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SenderTest {



	@Autowired
	private Sender sender;

	@Test
	public void send() {

		sender.send();
	}



	@Test
	public void sendRequest() {
		sender.sendRequest(Request.builder()
				.method(RequestMethod.POST)
				.path("/qwer/asdf")
				.id(3)
				.requestBody("{\"xiao\":4,\"da\":7}")
				.build());

	}
}