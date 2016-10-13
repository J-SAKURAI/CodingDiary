package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Mails entity. @author MyEclipse Persistence Tools
 */

public class Mails implements java.io.Serializable {

	// Fields

	private Long id;
	private Events events;
	private Users users;
	private String link;
	private String subject;
	private Integer type;//0草稿1已发送 2:已删除(发件箱中彻底 草稿箱删除 均不显示在垃圾箱)
	private String content;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set receiveMailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Mails() {
	}

	/** full constructor */
	public Mails(Events events, Users users, String link, String subject,
			Integer type, String content, Timestamp crtTm, String crtUsr,
			Timestamp updTm, String updUsr, Set receiveMailses) {
		this.events = events;
		this.users = users;
		this.link = link;
		this.subject = subject;
		this.type = type;
		this.content = content;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.receiveMailses = receiveMailses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Events getEvents() {
		return this.events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Set getReceiveMailses() {
		return this.receiveMailses;
	}

	public void setReceiveMailses(Set receiveMailses) {
		this.receiveMailses = receiveMailses;
	}

}