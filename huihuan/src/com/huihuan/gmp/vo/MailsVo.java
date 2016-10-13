package com.huihuan.gmp.vo;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.huihuan.gmp.entity.Mails;
import com.huihuan.gmp.entity.ReceiveMails;

/**
 * Mails entity. @author MyEclipse Persistence Tools
 */

public class MailsVo implements java.io.Serializable {

	// Fields
	private String sendTime;
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	private Long id;
	private Long events;
	private Long users;
	private String link;
	private String subject;
	private Integer type;
	private String content;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set receiveMailses = new HashSet(0);
	private String usersName;
	 DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	/** 邮件状态 status
	 * 由于表建的不好，所以这里要加一个status字段，这个字段本是recievemial里面的字段
	 * */
	private int status;
	// Constructors
	private	Long itemId;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	/** default constructor */
	public MailsVo() {
	}

	public MailsVo(Mails mails) {
		this.events = mails.getEvents()!=null?mails.getEvents().getId():null;
		this.users = mails.getUsers()!=null?mails.getUsers().getId():null;
		this.link =mails.getLink();
		this.subject =mails.getSubject();
		this.type = mails.getType();
		this.content = mails.getContent();
		this.crtTm =mails.getCrtTm();
		this.crtUsr = mails.getCrtUsr();
		this.updTm = mails.getUpdTm();
		 sendTime=sdf.format(mails.getCrtTm());//暂时替代
		this.updUsr =mails.getUpdUsr();
		this.id=mails.getId();
		this.itemId=this.id;
		this.usersName=mails.getUsers().getName();
		for(Object rec : mails.getReceiveMailses()){
			this.receiveMailses.add(new ReceiveMailsVo(((ReceiveMails) rec)));
		}
	}
	/** full constructor */
	public MailsVo(Long events, Long users, String link, String subject,
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

	public Long getEvents() {
		return this.events;
	}

	public void setEvents(Long events) {
		this.events = events;
	}

	public Long getUsers() {
		return this.users;
	}

	public void setUsers(Long users) {
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

	public Date getCrtTm() {
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