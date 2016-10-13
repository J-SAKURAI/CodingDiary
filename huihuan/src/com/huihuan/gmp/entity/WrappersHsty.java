package com.huihuan.gmp.entity;

import java.sql.Timestamp;

/**
 * WrappersHsty entity. @author MyEclipse Persistence Tools
 */

public class WrappersHsty implements java.io.Serializable {

	// Fields

	private Long id;
	private Wrappers wrappers;
	private String name;
	private String code;
	private String machineCode;
	private String userDefinedCode;
	private String usedName;
	private String preUnitCnvrsnFctr;
	private String quantityUnitName1;
	private String quantityUnitName2;
	private String unitCnvrsnFctr;
	private String baseQuantityUnitName;
	private Integer specialManageType;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Timestamp checkTm;
	private String checkUsr;

	// Constructors

	/** default constructor */
	public WrappersHsty() {
	}

	/** full constructor */
	public WrappersHsty(Wrappers wrappers, String name, String code,
			String machineCode, String userDefinedCode, String usedName,
			String preUnitCnvrsnFctr, String quantityUnitName1,
			String quantityUnitName2, String unitCnvrsnFctr,
			String baseQuantityUnitName, Integer specialManageType,
			Integer status, Timestamp crtTm, String crtUsr, Timestamp updTm,
			String updUsr, Timestamp checkTm, String checkUsr) {
		this.wrappers = wrappers;
		this.name = name;
		this.code = code;
		this.machineCode = machineCode;
		this.userDefinedCode = userDefinedCode;
		this.usedName = usedName;
		this.preUnitCnvrsnFctr = preUnitCnvrsnFctr;
		this.quantityUnitName1 = quantityUnitName1;
		this.quantityUnitName2 = quantityUnitName2;
		this.unitCnvrsnFctr = unitCnvrsnFctr;
		this.baseQuantityUnitName = baseQuantityUnitName;
		this.specialManageType = specialManageType;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.checkTm = checkTm;
		this.checkUsr = checkUsr;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Wrappers getWrappers() {
		return this.wrappers;
	}

	public void setWrappers(Wrappers wrappers) {
		this.wrappers = wrappers;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMachineCode() {
		return this.machineCode;
	}

	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}

	public String getUserDefinedCode() {
		return this.userDefinedCode;
	}

	public void setUserDefinedCode(String userDefinedCode) {
		this.userDefinedCode = userDefinedCode;
	}

	public String getUsedName() {
		return this.usedName;
	}

	public void setUsedName(String usedName) {
		this.usedName = usedName;
	}

	public String getPreUnitCnvrsnFctr() {
		return this.preUnitCnvrsnFctr;
	}

	public void setPreUnitCnvrsnFctr(String preUnitCnvrsnFctr) {
		this.preUnitCnvrsnFctr = preUnitCnvrsnFctr;
	}

	public String getQuantityUnitName1() {
		return this.quantityUnitName1;
	}

	public void setQuantityUnitName1(String quantityUnitName1) {
		this.quantityUnitName1 = quantityUnitName1;
	}

	public String getQuantityUnitName2() {
		return this.quantityUnitName2;
	}

	public void setQuantityUnitName2(String quantityUnitName2) {
		this.quantityUnitName2 = quantityUnitName2;
	}

	public String getUnitCnvrsnFctr() {
		return this.unitCnvrsnFctr;
	}

	public void setUnitCnvrsnFctr(String unitCnvrsnFctr) {
		this.unitCnvrsnFctr = unitCnvrsnFctr;
	}

	public String getBaseQuantityUnitName() {
		return this.baseQuantityUnitName;
	}

	public void setBaseQuantityUnitName(String baseQuantityUnitName) {
		this.baseQuantityUnitName = baseQuantityUnitName;
	}

	public Integer getSpecialManageType() {
		return this.specialManageType;
	}

	public void setSpecialManageType(Integer specialManageType) {
		this.specialManageType = specialManageType;
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

	public Timestamp getCheckTm() {
		return this.checkTm;
	}

	public void setCheckTm(Timestamp checkTm) {
		this.checkTm = checkTm;
	}

	public String getCheckUsr() {
		return this.checkUsr;
	}

	public void setCheckUsr(String checkUsr) {
		this.checkUsr = checkUsr;
	}

}