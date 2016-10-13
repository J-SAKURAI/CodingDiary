package com.huihuan.gmp.vo;

import java.sql.Timestamp;

import com.huihuan.gmp.entity.Catagories;

public class CatagoryDetailVo {
	private Long id;
	private String code;
	private String name;
	private String length;
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
