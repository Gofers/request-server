package com.gofers.requestserver.dao;

import com.gofers.requestserver.bean.Request;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fangzongzhou
 */
public interface RequestJpa extends JpaRepository<Request,Integer> {
}
