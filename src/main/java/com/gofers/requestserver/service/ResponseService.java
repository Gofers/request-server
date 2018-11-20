package com.gofers.requestserver.service;

import com.gofers.requestserver.bean.Response;

/**
 * @author 73956
 */
public interface ResponseService {
    /**
     *
     */
	void doPost();

	/**
	 * @param requestId
	 * @return
	 */
	Response findByRequestId(int requestId);

    Response findById(int responseId);
}
