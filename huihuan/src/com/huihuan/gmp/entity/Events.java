package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Events entity. @author MyEclipse Persistence Tools
 */

public class Events implements java.io.Serializable {

	// Fields

	private Long id;
	private String title;
	private Integer isAllDay;
	private Integer repeatingType;
	private String text;
	private Timestamp startTime;
	private Timestamp endTime;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set mailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Events() {
	}

	/** full constructor */
	public Events(String title, Integer isAllDay, Integer repeatingType,
			String text, Timestamp startTime, Timestamp endTime,
			Timestamp crtTm, String crtUsr, Timestamp updTm, String updUsr,
			Set mailses) {
		this.title = title;
		this.isAllDay = isAllDay;
		this.repeatingType = repeatingType;
		this.text = text;
		this.startTime = startTime;
		this.endTime = endTime;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.mailses = mailses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getIsAllDay() {
		return this.isAllDay;
	}

	public void setIsAllDay(Integer isAllDay) {
		this.isAllDay = isAllDay;
	}

	public Integer getRepeatingType() {
		return this.repeatingType;
	}

	public void setRepeatingType(Integer repeatingType) {
		this.repeatingType = repeatingType;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
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

	public Set getMailses() {
		return this.mailses;
	}

	public void setMailses(Set mailses) {
		this.mailses = mailses;
	}

}