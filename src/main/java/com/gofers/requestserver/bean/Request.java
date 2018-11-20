package com.gofers.requestserver.bean;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author fangzongzhou
 */
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	@Column
	private String path;
	@Column
	private RequestMethod method;
	@Column
	private String requestBody;


}
