package com.huihuan.gmp.entity;

import java.sql.Timestamp;

/**
 * PreFormulas entity. @author MyEclipse Persistence Tools
 */

public class PreFormulas implements java.io.Serializable {

	// Fields

	private Long id;
	private Materials materials;
	private String instruction;
	private String convertion;
	private String code;
	private Integer status;
	private Integer checkStatus;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Timestamp firstCheckTm;
	private String firstCheckUsr;
	private String firstCheckSuggestion;
	private Timestamp secondCheckTm;
	private String secondCheckUsr;
	private String secondCheckSuggestion;
	private Timestamp editTm;
	private String editUsr;
	private Timestamp effectiveTm;
	private Integer versionNum;

	// Constructors

	/** default constructor */
	public PreFormulas() {
	}

	/** full constructor */
	public PreFormulas(Materials materials, String instruction,
			String convertion, String code, Integer status,
			Integer checkStatus, Timestamp crtTm, String crtUsr,
			Timestamp updTm, String updUsr, Timestamp firstCheckTm,
			String firstCheckUsr, String firstCheckSuggestion,
			Timestamp secondCheckTm, String secondCheckUsr,
			String secondCheckSuggestion, Timestamp editTm, String editUsr,
			Timestamp effectiveTm, Integer versionNum) {
		this.materials = materials;
		this.instruction = instruction;
		this.convertion = convertion;
		this.code = code;
		this.status = status;
		this.checkStatus = checkStatus;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.firstCheckTm = firstCheckTm;
		this.firstCheckUsr = firstCheckUsr;
		this.firstCheckSuggestion = firstCheckSuggestion;
		this.secondCheckTm = secondCheckTm;
		this.secondCheckUsr = secondCheckUsr;
		this.secondCheckSuggestion = secondCheckSuggestion;
		this.editTm = editTm;
		this.editUsr = editUsr;
		this.effectiveTm = effectiveTm;
		this.versionNum = versionNum;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Materials getMaterials() {
		return this.materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getConvertion() {
		return this.convertion;
	}

	public void setConvertion(String convertion) {
		this.convertion = convertion;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(Integer checkStatus) {
		this.checkStatus = checkStatus;
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

	public Timestamp getFirstCheckTm() {
		return this.firstCheckTm;
	}

	public void setFirstCheckTm(Timestamp firstCheckTm) {
		this.firstCheckTm = firstCheckTm;
	}

	public String getFirstCheckUsr() {
		return this.firstCheckUsr;
	}

	public void setFirstCheckUsr(String firstCheckUsr) {
		this.firstCheckUsr = firstCheckUsr;
	}

	public String getFirstCheckSuggestion() {
		return this.firstCheckSuggestion;
	}

	public void setFirstCheckSuggestion(String firstCheckSuggestion) {
		this.firstCheckSuggestion = firstCheckSuggestion;
	}

	public Timestamp getSecondCheckTm() {
		return this.secondCheckTm;
	}

	public void setSecondCheckTm(Timestamp secondCheckTm) {
		this.secondCheckTm = secondCheckTm;
	}

	public String getSecondCheckUsr() {
		return this.secondCheckUsr;
	}

	public void setSecondCheckUsr(String secondCheckUsr) {
		this.secondCheckUsr = secondCheckUsr;
	}

	public String getSecondCheckSuggestion() {
		return this.secondCheckSuggestion;
	}

	public void setSecondCheckSuggestion(String secondCheckSuggestion) {
		this.secondCheckSuggestion = secondCheckSuggestion;
	}

	public Timestamp getEditTm() {
		return this.editTm;
	}

	public void setEditTm(Timestamp editTm) {
		this.editTm = editTm;
	}

	public String getEditUsr() {
		return this.editUsr;
	}

	public void setEditUsr(String editUsr) {
		this.editUsr = editUsr;
	}

	public Timestamp getEffectiveTm() {
		return this.effectiveTm;
	}

	public void setEffectiveTm(Timestamp effectiveTm) {
		this.effectiveTm = effectiveTm;
	}

	public Integer getVersionNum() {
		return this.versionNum;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}

}