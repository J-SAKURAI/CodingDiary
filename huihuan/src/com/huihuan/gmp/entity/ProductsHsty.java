package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * ProductsHsty entity. @author MyEclipse Persistence Tools
 */

public class ProductsHsty implements java.io.Serializable {

	// Fields

	private Long id;
	private Products products;
	private String name;
	private String sameCatagorieName;
	private String sameCatagorieCd;
	private String code;
	private Integer isMiddle;
	private String materialName;
	private String specification;
	private String machineCode;
	private String userDefinedCode;
	private String usedName;
	private String codeName;
	private String productUnit;
	private Float preUnitCnvrsnFctr;
	private String quantityUnitName1;
	private String quantityUnitName2;
	private Float unitCnvrsnFctr;
	private String baseQuantityUnitName;
	private String supervisonCode;
	private String approvalNumber;
	private Date approvalNumberValidDate;
	private Integer specialManageType;
	private String storageCondition;
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
	public ProductsHsty() {
	}

	/** full constructor */
	public ProductsHsty(Products products, String name,
			String sameCatagorieName, String sameCatagorieCd, String code,
			Integer isMiddle, String materialName, String specification,
			String machineCode, String userDefinedCode, String usedName,
			String codeName, String productUnit, Float preUnitCnvrsnFctr,
			String quantityUnitName1, String quantityUnitName2,
			Float unitCnvrsnFctr, String baseQuantityUnitName,
			String supervisonCode, String approvalNumber,
			Date approvalNumberValidDate, Integer specialManageType,
			String storageCondition, Integer validityPeriod,
			Integer warmingDay, Integer status, Timestamp crtTm, String crtUsr,
			Timestamp updTm, String updUsr, Timestamp checkTm, String checkUsr) {
		this.products = products;
		this.name = name;
		this.sameCatagorieName = sameCatagorieName;
		this.sameCatagorieCd = sameCatagorieCd;
		this.code = code;
		this.isMiddle = isMiddle;
		this.materialName = materialName;
		this.specification = specification;
		this.machineCode = machineCode;
		this.userDefinedCode = userDefinedCode;
		this.usedName = usedName;
		this.codeName = codeName;
		this.productUnit = productUnit;
		this.preUnitCnvrsnFctr = preUnitCnvrsnFctr;
		this.quantityUnitName1 = quantityUnitName1;
		this.quantityUnitName2 = quantityUnitName2;
		this.unitCnvrsnFctr = unitCnvrsnFctr;
		this.baseQuantityUnitName = baseQuantityUnitName;
		this.supervisonCode = supervisonCode;
		this.approvalNumber = approvalNumber;
		this.approvalNumberValidDate = approvalNumberValidDate;
		this.specialManageType = specialManageType;
		this.storageCondition = storageCondition;
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

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSameCatagorieName() {
		return this.sameCatagorieName;
	}

	public void setSameCatagorieName(String sameCatagorieName) {
		this.sameCatagorieName = sameCatagorieName;
	}

	public String getSameCatagorieCd() {
		return this.sameCatagorieCd;
	}

	public void setSameCatagorieCd(String sameCatagorieCd) {
		this.sameCatagorieCd = sameCatagorieCd;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getIsMiddle() {
		return this.isMiddle;
	}

	public void setIsMiddle(Integer isMiddle) {
		this.isMiddle = isMiddle;
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
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

	public String getCodeName() {
		return this.codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getProductUnit() {
		return this.productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public Float getPreUnitCnvrsnFctr() {
		return this.preUnitCnvrsnFctr;
	}

	public void setPreUnitCnvrsnFctr(Float preUnitCnvrsnFctr) {
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

	public Float getUnitCnvrsnFctr() {
		return this.unitCnvrsnFctr;
	}

	public void setUnitCnvrsnFctr(Float unitCnvrsnFctr) {
		this.unitCnvrsnFctr = unitCnvrsnFctr;
	}

	public String getBaseQuantityUnitName() {
		return this.baseQuantityUnitName;
	}

	public void setBaseQuantityUnitName(String baseQuantityUnitName) {
		this.baseQuantityUnitName = baseQuantityUnitName;
	}

	public String getSupervisonCode() {
		return this.supervisonCode;
	}

	public void setSupervisonCode(String supervisonCode) {
		this.supervisonCode = supervisonCode;
	}

	public String getApprovalNumber() {
		return this.approvalNumber;
	}

	public void setApprovalNumber(String approvalNumber) {
		this.approvalNumber = approvalNumber;
	}

	public Date getApprovalNumberValidDate() {
		return this.approvalNumberValidDate;
	}

	public void setApprovalNumberValidDate(Date approvalNumberValidDate) {
		this.approvalNumberValidDate = approvalNumberValidDate;
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