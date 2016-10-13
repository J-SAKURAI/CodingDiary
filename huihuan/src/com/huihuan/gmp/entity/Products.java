package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Products entity. @author MyEclipse Persistence Tools
 */

public class Products implements java.io.Serializable {

	// Fields

	private Long id;
	private Units unitsByBaseQuantityUnitId;
	private Units unitsByQuantityUnitId1;
	private Units unitsByQuantityUnitId2;
	private Materials materials;
	private SameCatagories sameCatagories;
	private String name;
	private String code;
	private Integer isMiddle;
	private String specification;
	private String machineCode;
	private String userDefinedCode;
	private String usedName;
	private String codeName;
	private String productUnit;
	private String preUnitCnvrsnFctr;
	private String unitCnvrsnFctr;
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
	private Set productsHsties = new HashSet(0);
	private Set formulases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Products() {
	}

	/** minimal constructor */
	public Products(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public Products(Units unitsByBaseQuantityUnitId,
			Units unitsByQuantityUnitId1, Units unitsByQuantityUnitId2,
			Materials materials, SameCatagories sameCatagories, String name,
			String code, Integer isMiddle, String specification,
			String machineCode, String userDefinedCode, String usedName,
			String codeName, String productUnit, String preUnitCnvrsnFctr,
			String unitCnvrsnFctr, String supervisonCode,
			String approvalNumber, Date approvalNumberValidDate,
			Integer specialManageType, String storageCondition,
			Integer validityPeriod, Integer warmingDay, Integer status,
			Timestamp crtTm, String crtUsr, Timestamp updTm, String updUsr,
			Timestamp checkTm, String checkUsr, Set productsHsties,
			Set formulases) {
		this.unitsByBaseQuantityUnitId = unitsByBaseQuantityUnitId;
		this.unitsByQuantityUnitId1 = unitsByQuantityUnitId1;
		this.unitsByQuantityUnitId2 = unitsByQuantityUnitId2;
		this.materials = materials;
		this.sameCatagories = sameCatagories;
		this.name = name;
		this.code = code;
		this.isMiddle = isMiddle;
		this.specification = specification;
		this.machineCode = machineCode;
		this.userDefinedCode = userDefinedCode;
		this.usedName = usedName;
		this.codeName = codeName;
		this.productUnit = productUnit;
		this.preUnitCnvrsnFctr = preUnitCnvrsnFctr;
		this.unitCnvrsnFctr = unitCnvrsnFctr;
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
		this.productsHsties = productsHsties;
		this.formulases = formulases;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Units getUnitsByBaseQuantityUnitId() {
		return this.unitsByBaseQuantityUnitId;
	}

	public void setUnitsByBaseQuantityUnitId(Units unitsByBaseQuantityUnitId) {
		this.unitsByBaseQuantityUnitId = unitsByBaseQuantityUnitId;
	}

	public Units getUnitsByQuantityUnitId1() {
		return this.unitsByQuantityUnitId1;
	}

	public void setUnitsByQuantityUnitId1(Units unitsByQuantityUnitId1) {
		this.unitsByQuantityUnitId1 = unitsByQuantityUnitId1;
	}

	public Units getUnitsByQuantityUnitId2() {
		return this.unitsByQuantityUnitId2;
	}

	public void setUnitsByQuantityUnitId2(Units unitsByQuantityUnitId2) {
		this.unitsByQuantityUnitId2 = unitsByQuantityUnitId2;
	}

	public Materials getMaterials() {
		return this.materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	public SameCatagories getSameCatagories() {
		return this.sameCatagories;
	}

	public void setSameCatagories(SameCatagories sameCatagories) {
		this.sameCatagories = sameCatagories;
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

	public Integer getIsMiddle() {
		return this.isMiddle;
	}

	public void setIsMiddle(Integer isMiddle) {
		this.isMiddle = isMiddle;
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

	public String getPreUnitCnvrsnFctr() {
		return this.preUnitCnvrsnFctr;
	}

	public void setPreUnitCnvrsnFctr(String preUnitCnvrsnFctr) {
		this.preUnitCnvrsnFctr = preUnitCnvrsnFctr;
	}

	public String getUnitCnvrsnFctr() {
		return this.unitCnvrsnFctr;
	}

	public void setUnitCnvrsnFctr(String unitCnvrsnFctr) {
		this.unitCnvrsnFctr = unitCnvrsnFctr;
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

	public Set getProductsHsties() {
		return this.productsHsties;
	}

	public void setProductsHsties(Set productsHsties) {
		this.productsHsties = productsHsties;
	}

	public Set getFormulases() {
		return this.formulases;
	}

	public void setFormulases(Set formulases) {
		this.formulases = formulases;
	}

}