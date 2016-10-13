package com.huihuan.gmp.vo;

import java.sql.Timestamp;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

public class WorkshopVo {
	private Long id;
	private String name;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getCrtTm() {
		return crtTm;
	}
	public void setCrtTm(Timestamp crtTm) {
		this.crtTm = crtTm;
	}
	public String getCrtUsr() {
		return crtUsr;
	}
	public void setCrtUsr(String crtUsr) {
		this.crtUsr = crtUsr;
	}
	public Timestamp getUpdTm() {
		return updTm;
	}
	public void setUpdTm(Timestamp updTm) {
		this.updTm = updTm;
	}
	public String getUpdUsr() {
		return updUsr;
	}
	public void setUpdUsr(String updUsr) {
		this.updUsr = updUsr;
	}

	
}
