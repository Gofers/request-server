package com.gofers.requestserver.dao;

import com.gofers.requestserver.bean.Response;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fangzongzhou
 */
public interface ResponseJpa extends JpaRepository<Response, Integer> {

}
