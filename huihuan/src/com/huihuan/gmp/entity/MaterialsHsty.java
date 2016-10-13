package com.huihuan.gmp.entity;

import java.sql.Timestamp;

/**
 * MaterialsHsty entity. @author MyEclipse Persistence Tools
 */

public class MaterialsHsty implements java.io.Serializable {

	// Fields

	private Long id;
	private Materials materials;
	private String name;
	private String catagoryCode;
	private String code;
	private String machineCode;
	private String productName;
	private String userDefinedCode;
	private String usedName;
	private String preUnitCnvrsnFctr;
	private String quantityUnitName1;
	private String quantityUnitName2;
	private String unitCnvrsnFctr;
	private String baseQuantityUnitName;
	private Integer specialManageType;
	private String storageCondition;
	private Integer validityManageType;
	private String photoUrl;
	private Integer validityPeriod;
	private Integer warmingDay;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Timestamp checkTm;
	private String checkUsr;

	// Constructors

	/** default constructor */
	public MaterialsHsty() {
	}

	/** full constructor */
	public MaterialsHsty(Materials materials, String name, String catagoryCode,
			String code, String machineCode, String productName,
			String userDefinedCode, String usedName, String preUnitCnvrsnFctr,
			String quantityUnitName1, String quantityUnitName2,
			String unitCnvrsnFctr, String baseQuantityUnitName,
			Integer specialManageType, String storageCondition,
			Integer validityManageType, String photoUrl,
			Integer validityPeriod, Integer warmingDay, Integer status,
			Timestamp crtTm, String crtUsr, Timestamp updTm, String updUsr,
			Timestamp checkTm, String checkUsr) {
		this.materials = materials;
		this.name = name;
		this.catagoryCode = catagoryCode;
		this.code = code;
		this.machineCode = machineCode;
		this.productName = productName;
		this.userDefinedCode = userDefinedCode;
		this.usedName = usedName;
		this.preUnitCnvrsnFctr = preUnitCnvrsnFctr;
		this.quantityUnitName1 = quantityUnitName1;
		this.quantityUnitName2 = quantityUnitName2;
		this.unitCnvrsnFctr = unitCnvrsnFctr;
		this.baseQuantityUnitName = baseQuantityUnitName;
		this.specialManageType = specialManageType;
		this.storageCondition = storageCondition;
		this.validityManageType = validityManageType;
		this.photoUrl = photoUrl;
		this.validityPeriod = validityPeriod;
		this.warmingDay = warmingDay;
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

	public Materials getMaterials() {
		return this.materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatagoryCode() {
		return this.catagoryCode;
	}

	public void setCatagoryCode(String catagoryCode) {
		this.catagoryCode = catagoryCode;
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

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getStorageCondition() {
		return this.storageCondition;
	}

	public void setStorageCondition(String storageCondition) {
		this.storageCondition = storageCondition;
	}

	public Integer getValidityManageType() {
		return this.validityManageType;
	}

	public void setValidityManageType(Integer validityManageType) {
		this.validityManageType = validityManageType;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Integer getValidityPeriod() {
		return this.validityPeriod;
	}

	public void setValidityPeriod(Integer validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public Integer getWarmingDay() {
		return this.warmingDay;
	}

	public void setWarmingDay(Integer warmingDay) {
		this.warmingDay = warmingDay;
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