package com.gofers.requestserver.service;

import com.gofers.requestserver.bean.Request;
import com.gofers.requestserver.dao.RequestJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangzongzhou
 */
@Service
public class ResponseServiceImpl implements ResponseService {

	@Autowired
	RequestJpa requestJpa;
	@Override
	@Async
	public void doPost() {
		Request request = requestJpa.findAll().get(0);
		System.out.println(request);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://127.0.0.1:8080"+request.getPath();
		System.out.println(url);
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request.getRequestBody(), String.class);
		System.out.println(responseEntity.getBody());
	}
}
