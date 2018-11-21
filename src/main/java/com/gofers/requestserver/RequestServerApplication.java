package com.gofers.requestserver;

import javax.servlet.http.HttpServletRequest;

import com.gofers.requestserver.bean.Request;
import com.gofers.requestserver.dao.RequestJpa;
import com.gofers.requestserver.dao.ResponseJpa;
import com.gofers.requestserver.message.Sender;
import com.gofers.requestserver.service.RequestService;
import com.gofers.requestserver.service.ResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

/**
 * @author fangzongzhou
 */
@SpringBootApplication
@RestController
public class RequestServerApplication {

	@Autowired
	RequestJpa requestJpa;
	@Autowired
	ResponseJpa responseJpa;
	@Autowired
	RequestService requestService;
	@Autowired
	private Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(RequestServerApplication.class, args);
	}


	@RequestMapping(method = RequestMethod.GET, path = "/**")
	public String getRequest(HttpServletRequest request) throws InterruptedException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(request.getMethod());
		System.out.println(request.getServletPath());
		System.out.println("asdfa");
		System.out.println(request.getQueryString());

		Request requestEntity = Request.builder()
				.path(request.getServletPath())
				.method(RequestMethod.GET)
				.requestBody(request.getQueryString())
				.build();
		requestEntity = requestJpa.save(requestEntity);
		sender.sendRequest(Request.builder()
				.method(RequestMethod.GET)
				.path(requestEntity.getPath())
				.id(requestEntity.getId())
				.requestBody(requestEntity.getRequestBody())
				.build());
		requestEntity = requestJpa.save(requestEntity);
		Thread.sleep(1000);
		int requestId=requestEntity.getId();
		requestEntity = requestService.findById(requestId);
		int responseId=requestEntity.getResponseId();
		String resp = responseJpa.findByRequestId(requestId).getResponse();




		return resp;

	}

	@RequestMapping(method = RequestMethod.POST, path = "/**")
	public String postRequest( HttpServletRequest request,
	@RequestBody String requestBody) throws InterruptedException {
		RestTemplate restTemplate = new RestTemplate();

		Request requestEntity = Request.builder()
				.method(RequestMethod.POST)
				.path(request.getServletPath())
				.requestBody(requestBody)
				.build();
		requestEntity=requestJpa.save(requestEntity);
		sender.sendRequest(Request.builder()
				.method(RequestMethod.POST)
				.path(requestEntity.getPath())
				.id(requestEntity.getId())
				.requestBody(requestEntity.getRequestBody())
				.build());

		System.out.println(requestEntity.toString());

		requestEntity = requestJpa.save(requestEntity);
		Thread.sleep(1000);
		int requestId=requestEntity.getId();
		requestEntity = requestService.findById(requestId);
		int responseId=requestEntity.getResponseId();
		String resp = responseJpa.findByRequestId(requestId).getResponse();




		return resp;
	}

	@Autowired
	ResponseService responseService;
	@RequestMapping("/dopost")
	public String asdfasdf() {
		 responseService.doPost();
		return "xiao";
	}


	@RequestMapping("/test/test")
	public String asdf() {
		System.out.println("fasd");
		return "asdf";
	}
}
