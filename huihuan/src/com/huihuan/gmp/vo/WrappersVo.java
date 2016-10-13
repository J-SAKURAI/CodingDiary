package com.huihuan.gmp.vo;

import java.util.List;

public class WrappersVo {
	private Long id;
	private String name;
	
	
	private String quantityUnit1;
	private String quantityUnit2;
	
	
	private List catagoryId;
	
	public List getCatagoryId() {
		return catagoryId;
	}
	public void setCatagoryId(List catagoryId) {
		this.catagoryId = catagoryId;
	}
	public String getQuantityUnit1() {
		return quantityUnit1;
	}
	public void setQuantityUnit1(String quantityUnit1) {
		this.quantityUnit1 = quantityUnit1;
	}
	public String getQuantityUnit2() {
		return quantityUnit2;
	}
	public void setQuantityUnit2(String quantityUnit2) {
		this.quantityUnit2 = quantityUnit2;
	}
	
	private String preUnitCnvrsnFctr;

	
	public String getPreUnitCnvrsnFctr() {
		return preUnitCnvrsnFctr;
	}
	public void setPreUnitCnvrsnFctr(String preUnitCnvrsnFctr) {
		this.preUnitCnvrsnFctr = preUnitCnvrsnFctr;
	}

	private String catagoryCode;
	private String code;
	private String userDefinedCode;
	private String usedName;
	//private String quantityUnit;
	private String unitCnvrsnFctr;
	private String baseQuantityUnit;
	private Integer isRepeatWeight;
	private Float toleranceRange;
	private String repeatWeightFormula;
	private Integer specialManageType;
	private String machineCode;
	private Integer status;
	public String getMachineCode() {
		return machineCode;
	}
	public void setMachineCode(String machineCode) {
		this.machineCode = machineCode;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatagoryCode() {
		return catagoryCode;
	}
	public void setCatagoryCode(String catagoryCode) {
		this.catagoryCode = catagoryCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserDefinedCode() {
		return userDefinedCode;
	}
	public void setUserDefinedCode(String userDefinedCode) {
		this.userDefinedCode = userDefinedCode;
	}
	public String getUsedName() {
		return usedName;
	}
	public void setUsedName(String usedName) {
		this.usedName = usedName;
	}
//	public String getQuantityUnit() {
//		return quantityUnit;
//	}
//	public void setQuantityUnit(String quantityUnit) {
//		this.quantityUnit = quantityUnit;
//	}
	public String getUnitCnvrsnFctr() {
		return unitCnvrsnFctr;
	}
	public void setUnitCnvrsnFctr(String unitCnvrsnFctr) {
		this.unitCnvrsnFctr = unitCnvrsnFctr;
	}
	public String getBaseQuantityUnit() {
		return baseQuantityUnit;
	}
	public void setBaseQuantityUnit(String baseQuantityUnit) {
		this.baseQuantityUnit = baseQuantityUnit;
	}
	public Integer getIsRepeatWeight() {
		return isRepeatWeight;
	}
	public void setIsRepeatWeight(Integer isRepeatWeight) {
		this.isRepeatWeight = isRepeatWeight;
	}
	public Float getToleranceRange() {
		return toleranceRange;
	}
	public void setToleranceRange(Float toleranceRange) {
		this.toleranceRange = toleranceRange;
	}
	public String getRepeatWeightFormula() {
		return repeatWeightFormula;
	}
	public void setRepeatWeightFormula(String repeatWeightFormula) {
		this.repeatWeightFormula = repeatWeightFormula;
	}
	public Integer getSpecialManageType() {
		return specialManageType;
	}
	public void setSpecialManageType(Integer specialManageType) {
		this.specialManageType = specialManageType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
