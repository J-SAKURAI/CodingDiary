package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Materials entity. @author MyEclipse Persistence Tools
 */

public class Materials implements java.io.Serializable {

	// Fields

	private Long id;
	private Units unitsByBaseQuantityUnitId;
	private Units unitsByQuantityUnitId1;
	private Units unitsByQuantityUnitId2;
	private String name;
	private String catagoryCode;
	private String code;
	private String machineCode;
	private Integer isMiddle;
	private Long productId;
	private String userDefinedCode;
	private String usedName;
	private String preUnitCnvrsnFctr;
	private String unitCnvrsnFctr;
	private Integer isRepeatWeight;
	private Float toleranceRange;
	private String repeatWeightFormula;
	private String supplementFormula;
	private Integer specialManageType;
	private Float minInventory;
	private Float maxInventory;
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
	private Set materialsHsties = new HashSet(0);
	private Set formulaMaterialses = new HashSet(0);
	private Set productses = new HashSet(0);
	private Set preFormulaMaterialses = new HashSet(0);
	private Set preFormulases = new HashSet(0);
	private Set materialCatagoryDetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Materials() {
	}

	/** minimal constructor */
	public Materials(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public Materials(Units unitsByBaseQuantityUnitId,
			Units unitsByQuantityUnitId1, Units unitsByQuantityUnitId2,
			String name, String catagoryCode, String code, String machineCode,
			Integer isMiddle, Long productId, String userDefinedCode,
			String usedName, String preUnitCnvrsnFctr, String unitCnvrsnFctr,
			Integer isRepeatWeight, Float toleranceRange,
			String repeatWeightFormula, String supplementFormula,
			Integer specialManageType, Float minInventory, Float maxInventory,
			String storageCondition, Integer validityManageType,
			String photoUrl, Integer validityPeriod, Integer warmingDay,
			Integer status, Timestamp crtTm, String crtUsr, Timestamp updTm,
			String updUsr, Timestamp checkTm, String checkUsr,
			Set materialsHsties, Set formulaMaterialses, Set productses,
			Set preFormulaMaterialses, Set preFormulases,
			Set materialCatagoryDetailses) {
		this.unitsByBaseQuantityUnitId = unitsByBaseQuantityUnitId;
		this.unitsByQuantityUnitId1 = unitsByQuantityUnitId1;
		this.unitsByQuantityUnitId2 = unitsByQuantityUnitId2;
		this.name = name;
		this.catagoryCode = catagoryCode;
		this.code = code;
		this.machineCode = machineCode;
		this.isMiddle = isMiddle;
		this.productId = productId;
		this.userDefinedCode = userDefinedCode;
		this.usedName = usedName;
		this.preUnitCnvrsnFctr = preUnitCnvrsnFctr;
		this.unitCnvrsnFctr = unitCnvrsnFctr;
		this.isRepeatWeight = isRepeatWeight;
		this.toleranceRange = toleranceRange;
		this.repeatWeightFormula = repeatWeightFormula;
		this.supplementFormula = supplementFormula;
		this.specialManageType = specialManageType;
		this.minInventory = minInventory;
		this.maxInventory = maxInventory;
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
		this.materialsHsties = materialsHsties;
		this.formulaMaterialses = formulaMaterialses;
		this.productses = productses;
		this.preFormulaMaterialses = preFormulaMaterialses;
		this.preFormulases = preFormulases;
		this.materialCatagoryDetailses = materialCatagoryDetailses;
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

	public Integer getIsMiddle() {
		return this.isMiddle;
	}

	public void setIsMiddle(Integer isMiddle) {
		this.isMiddle = isMiddle;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public String getUnitCnvrsnFctr() {
		return this.unitCnvrsnFctr;
	}

	public void setUnitCnvrsnFctr(String unitCnvrsnFctr) {
		this.unitCnvrsnFctr = unitCnvrsnFctr;
	}

	public Integer getIsRepeatWeight() {
		return this.isRepeatWeight;
	}

	public void setIsRepeatWeight(Integer isRepeatWeight) {
		this.isRepeatWeight = isRepeatWeight;
	}

	public Float getToleranceRange() {
		return this.toleranceRange;
	}

	public void setToleranceRange(Float toleranceRange) {
		this.toleranceRange = toleranceRange;
	}

	public String getRepeatWeightFormula() {
		return this.repeatWeightFormula;
	}

	public void setRepeatWeightFormula(String repeatWeightFormula) {
		this.repeatWeightFormula = repeatWeightFormula;
	}

	public String getSupplementFormula() {
		return this.supplementFormula;
	}

	public void setSupplementFormula(String supplementFormula) {
		this.supplementFormula = supplementFormula;
	}

	public Integer getSpecialManageType() {
		return this.specialManageType;
	}

	public void setSpecialManageType(Integer specialManageType) {
		this.specialManageType = specialManageType;
	}

	public Float getMinInventory() {
		return this.minInventory;
	}

	public void setMinInventory(Float minInventory) {
		this.minInventory = minInventory;
	}

	public Float getMaxInventory() {
		return this.maxInventory;
	}

	public void setMaxInventory(Float maxInventory) {
		this.maxInventory = maxInventory;
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

	public Set getMaterialsHsties() {
		return this.materialsHsties;
	}

	public void setMaterialsHsties(Set materialsHsties) {
		this.materialsHsties = materialsHsties;
	}

	public Set getFormulaMaterialses() {
		return this.formulaMaterialses;
	}

	public void setFormulaMaterialses(Set formulaMaterialses) {
		this.formulaMaterialses = formulaMaterialses;
	}

	public Set getProductses() {
		return this.productses;
	}

	public void setProductses(Set productses) {
		this.productses = productses;
	}

	public Set getPreFormulaMaterialses() {
		return this.preFormulaMaterialses;
	}

	public void setPreFormulaMaterialses(Set preFormulaMaterialses) {
		this.preFormulaMaterialses = preFormulaMaterialses;
	}

	public Set getPreFormulases() {
		return this.preFormulases;
	}

	public void setPreFormulases(Set preFormulases) {
		this.preFormulases = preFormulases;
	}

	public Set getMaterialCatagoryDetailses() {
		return this.materialCatagoryDetailses;
	}

	public void setMaterialCatagoryDetailses(Set materialCatagoryDetailses) {
		this.materialCatagoryDetailses = materialCatagoryDetailses;
	}

}