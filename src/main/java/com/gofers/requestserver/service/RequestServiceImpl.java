package com.gofers.requestserver.service;

import com.gofers.requestserver.bean.Request;
import com.gofers.requestserver.dao.RequestJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fangzongzhou
 */
@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	RequestJpa requestJpa;
	@Override
	public int save(Request request) {

		return requestJpa.save(request).getId();
	}

	@Override
	public Request findById(int requestId) {
		return requestJpa.findById(requestId).get();
	}


}
