package com.gofers.requestserver;

import javax.servlet.http.HttpServletRequest;

import com.gofers.requestserver.bean.Request;
import com.gofers.requestserver.dao.RequestJpa;
import com.gofers.requestserver.service.ResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangzongzhou
 */
@SpringBootApplication
@RestController
public class RequestServerApplication {

	@Autowired
	RequestJpa requestJpa;

	public static void main(String[] args) {
		SpringApplication.run(RequestServerApplication.class, args);
	}


	@RequestMapping(method = RequestMethod.GET, path = "/**")
	public String getRequest(HttpServletRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(request.getMethod());
		System.out.println(request.getServletPath());
		System.out.println("asdfa");
		System.out.println(request.getQueryString());

		Request requestEntity = Request.builder()
				.path(request.getServletPath())
				.method(RequestMethod.GET.name())
				.requestBody(request.getQueryString())
				.build();
		requestJpa.save(requestEntity);
		return "asdf";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/**")
	public String postRequest( HttpServletRequest request,
	@RequestBody String requestBody) {
		RestTemplate restTemplate = new RestTemplate();

		Request requestEntity = Request.builder()
				.method(RequestMethod.POST.name())
				.path(request.getServletPath())
				.requestBody(requestBody)
				.build();
		System.out.println(requestEntity.toString());
		requestJpa.save(requestEntity);

		return "qwer";
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
