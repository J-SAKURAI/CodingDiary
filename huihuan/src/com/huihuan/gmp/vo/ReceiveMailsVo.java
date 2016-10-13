package com.huihuan.gmp.vo;

import java.sql.Timestamp;

import com.huihuan.gmp.entity.ReceiveMails;

public class ReceiveMailsVo {

	private Long id;
	private long mailsid;
	private long usersid;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private String userName;

	ReceiveMailsVo(ReceiveMails rm) {
		id=rm.getId();
		 mailsid=rm.getMails().getId();
		 usersid=rm.getUsers().getId();
		  status=rm.getStatus();
		  crtTm=rm.getCrtTm();
		 crtUsr=rm.getCrtUsr();
		 updTm=rm.getUpdTm();
		 updUsr=rm.getUpdUsr();
		  userName=rm.getUsers().getUsername();
		  name=rm.getUsers().getName();
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getMailsid() {
		return mailsid;
	}

	public void setMailsid(long mailsid) {
		this.mailsid = mailsid;
	}

	public long getUsersid() {
		return usersid;
	}

	public void setUsersid(long usersid) {
		this.usersid = usersid;
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
