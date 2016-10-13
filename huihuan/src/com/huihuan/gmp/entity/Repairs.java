package com.huihuan.gmp.entity;

import java.sql.Timestamp;

/**
 * Repairs entity. @author MyEclipse Persistence Tools
 */

public class Repairs implements java.io.Serializable {

	// Fields

	private Long id;
	private Users usersBySubmitUserId;
	private Users usersByConfirmUserId;
	private Users usersByHandleUserId;
	private String repairCd;
	private Long moduleId;
	private Timestamp submitTime;
	private Integer type;
	private String repairText;
	private Timestamp handleTime;
	private String handleText;
	private String handleResult;
	private Timestamp confirmTime;
	private String confirmResult;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;

	// Constructors

	/** default constructor */
	public Repairs() {
	}

	/** full constructor */
	public Repairs(Users usersBySubmitUserId, Users usersByConfirmUserId,
			Users usersByHandleUserId, String repairCd, Long moduleId,
			Timestamp submitTime, Integer type, String repairText,
			Timestamp handleTime, String handleText, String handleResult,
			Timestamp confirmTime, String confirmResult, Timestamp crtTm,
			String crtUsr, Timestamp updTm, String updUsr) {
		this.usersBySubmitUserId = usersBySubmitUserId;
		this.usersByConfirmUserId = usersByConfirmUserId;
		this.usersByHandleUserId = usersByHandleUserId;
		this.repairCd = repairCd;
		this.moduleId = moduleId;
		this.submitTime = submitTime;
		this.type = type;
		this.repairText = repairText;
		this.handleTime = handleTime;
		this.handleText = handleText;
		this.handleResult = handleResult;
		this.confirmTime = confirmTime;
		this.confirmResult = confirmResult;
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

	public Users getUsersBySubmitUserId() {
		return this.usersBySubmitUserId;
	}

	public void setUsersBySubmitUserId(Users usersBySubmitUserId) {
		this.usersBySubmitUserId = usersBySubmitUserId;
	}

	public Users getUsersByConfirmUserId() {
		return this.usersByConfirmUserId;
	}

	public void setUsersByConfirmUserId(Users usersByConfirmUserId) {
		this.usersByConfirmUserId = usersByConfirmUserId;
	}

	public Users getUsersByHandleUserId() {
		return this.usersByHandleUserId;
	}

	public void setUsersByHandleUserId(Users usersByHandleUserId) {
		this.usersByHandleUserId = usersByHandleUserId;
	}

	public String getRepairCd() {
		return this.repairCd;
	}

	public void setRepairCd(String repairCd) {
		this.repairCd = repairCd;
	}

	public Long getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRepairText() {
		return this.repairText;
	}

	public void setRepairText(String repairText) {
		this.repairText = repairText;
	}

	public Timestamp getHandleTime() {
		return this.handleTime;
	}

	public void setHandleTime(Timestamp handleTime) {
		this.handleTime = handleTime;
	}

	public String getHandleText() {
		return this.handleText;
	}

	public void setHandleText(String handleText) {
		this.handleText = handleText;
	}

	public String getHandleResult() {
		return this.handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}

	public Timestamp getConfirmTime() {
		return this.confirmTime;
	}

	public void setConfirmTime(Timestamp confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getConfirmResult() {
		return this.confirmResult;
	}

	public void setConfirmResult(String confirmResult) {
		this.confirmResult = confirmResult;
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