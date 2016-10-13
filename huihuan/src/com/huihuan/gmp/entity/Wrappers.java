package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Wrappers entity. @author MyEclipse Persistence Tools
 */

public class Wrappers implements java.io.Serializable {

	// Fields

	private Long id;
	private Units unitsByBaseQuantityUnitId;
	private Units unitsByQuantityUnitId1;
	private Units unitsByQuantityUnitId2;
	private String name;
	private String catagoryCode;
	private String code;
	private String machineCode;
	private String userDefinedCode;
	private String usedName;
	private String preUnitCnvrsnFctr;
	private String unitCnvrsnFctr;
	private Integer isRepeatWeight;
	private Float toleranceRange;
	private String repeatWeightFormula;
	private Integer specialManageType;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Timestamp checkTm;
	private String checkUsr;
	private Set wrapperCatagoryDetailses = new HashSet(0);
	private Set wrappersHsties = new HashSet(0);

	// Constructors

	/** default constructor */
	public Wrappers() {
	}

	/** minimal constructor */
	public Wrappers(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public Wrappers(Units unitsByBaseQuantityUnitId,
			Units unitsByQuantityUnitId1, Units unitsByQuantityUnitId2,
			String name, String catagoryCode, String code, String machineCode,
			String userDefinedCode, String usedName, String preUnitCnvrsnFctr,
			String unitCnvrsnFctr, Integer isRepeatWeight,
			Float toleranceRange, String repeatWeightFormula,
			Integer specialManageType, Integer status, Timestamp crtTm,
			String crtUsr, Timestamp updTm, String updUsr, Timestamp checkTm,
			String checkUsr, Set wrapperCatagoryDetailses, Set wrappersHsties) {
		this.unitsByBaseQuantityUnitId = unitsByBaseQuantityUnitId;
		this.unitsByQuantityUnitId1 = unitsByQuantityUnitId1;
		this.unitsByQuantityUnitId2 = unitsByQuantityUnitId2;
		this.name = name;
		this.catagoryCode = catagoryCode;
		this.code = code;
		this.machineCode = machineCode;
		this.userDefinedCode = userDefinedCode;
		this.usedName = usedName;
		this.preUnitCnvrsnFctr = preUnitCnvrsnFctr;
		this.unitCnvrsnFctr = unitCnvrsnFctr;
		this.isRepeatWeight = isRepeatWeight;
		this.toleranceRange = toleranceRange;
		this.repeatWeightFormula = repeatWeightFormula;
		this.specialManageType = specialManageType;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.checkTm = checkTm;
		this.checkUsr = checkUsr;
		this.wrapperCatagoryDetailses = wrapperCatagoryDetailses;
		this.wrappersHsties = wrappersHsties;
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

	public Set getWrapperCatagoryDetailses() {
		return this.wrapperCatagoryDetailses;
	}

	public void setWrapperCatagoryDetailses(Set wrapperCatagoryDetailses) {
		this.wrapperCatagoryDetailses = wrapperCatagoryDetailses;
	}

	public Set getWrappersHsties() {
		return this.wrappersHsties;
	}

	public void setWrappersHsties(Set wrappersHsties) {
		this.wrappersHsties = wrappersHsties;
	}

}