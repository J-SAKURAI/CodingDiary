package com.huihuan.gmp.entity;

import java.sql.Timestamp;

/**
 * ReceiveMails entity. @author MyEclipse Persistence Tools
 */

public class ReceiveMails implements java.io.Serializable {

	// Fields

	private Long id;
	private Mails mails;
	private Users users;
	private Integer status;//0未读1已读-1已删除（在垃圾箱中） 2：彻底删除
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;

	// Constructors

	/** default constructor */
	public ReceiveMails() {
	}

	/** full constructor */
	public ReceiveMails(Mails mails, Users users, Integer status,
			Timestamp crtTm, String crtUsr, Timestamp updTm, String updUsr) {
		this.mails = mails;
		this.users = users;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mails getMails() {
		return this.mails;
	}

	public void setMails(Mails mails) {
		this.mails = mails;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCrtTm() {
		return this.crtTm;
	}

	public void setCrtTm(Timestamp crtTm) {
		this.crtTm = crtTm;
	}

	public String getCrtUsr() {
		return this.crtUsr;
	}

	public void setCrtUsr(String crtUsr) {
		this.crtUsr = crtUsr;
	}

	public Timestamp getUpdTm() {
		return this.updTm;
	}

	public void setUpdTm(Timestamp updTm) {
		this.updTm = updTm;
	}

	public String getUpdUsr() {
		return this.updUsr;
	}

	public void setUpdUsr(String updUsr) {
		this.updUsr = updUsr;
	}

}