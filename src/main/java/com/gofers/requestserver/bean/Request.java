package com.gofers.requestserver.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @author fangzongzhou
 */
@Entity
@Builder
@Data
public class Request {

	@Id
	@GeneratedValue
	private int id;
	@Column
	private String path;
	@Column
	private String method;
	@Column
	private String requestBody;


}
