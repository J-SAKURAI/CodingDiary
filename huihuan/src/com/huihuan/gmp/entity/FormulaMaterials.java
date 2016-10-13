package com.huihuan.gmp.entity;

import java.sql.Timestamp;

/**
 * FormulaMaterials entity. @author MyEclipse Persistence Tools
 */

public class FormulaMaterials implements java.io.Serializable {

	// Fields

	private Long id;
	private Units unitsByConfigQuantityUnitId;
	private Materials materials;
	private Formulas formulas;
	private Units unitsByIncreasedQuantityUnitId;
	private String formulaGroup;
	private Float mocProductQuantity;
	private Float configQuantity;
	private Float increasedQuantity;
	private Float differences;
	private Integer isUseDifferences;
	private Float increaseProportion;
	private Integer isMain;
	private Integer isCalculateBalance;
	private String supplementFormula;
	private Timestamp updTm;
	private String updUsr;
	private Integer position;

	// Constructors

	/** default constructor */
	public FormulaMaterials() {
	}

	/** minimal constructor */
	public FormulaMaterials(Timestamp updTm) {
		this.updTm = updTm;
	}

	/** full constructor */
	public FormulaMaterials(Units unitsByConfigQuantityUnitId,
			Materials materials, Formulas formulas,
			Units unitsByIncreasedQuantityUnitId, String formulaGroup,
			Float mocProductQuantity, Float configQuantity,
			Float increasedQuantity, Float differences,
			Integer isUseDifferences, Float increaseProportion, Integer isMain,
			Integer isCalculateBalance, String supplementFormula,
			Timestamp updTm, String updUsr, Integer position) {
		this.unitsByConfigQuantityUnitId = unitsByConfigQuantityUnitId;
		this.materials = materials;
		this.formulas = formulas;
		this.unitsByIncreasedQuantityUnitId = unitsByIncreasedQuantityUnitId;
		this.formulaGroup = formulaGroup;
		this.mocProductQuantity = mocProductQuantity;
		this.configQuantity = configQuantity;
		this.increasedQuantity = increasedQuantity;
		this.differences = differences;
		this.isUseDifferences = isUseDifferences;
		this.increaseProportion = increaseProportion;
		this.isMain = isMain;
		this.isCalculateBalance = isCalculateBalance;
		this.supplementFormula = supplementFormula;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.position = position;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Units getUnitsByConfigQuantityUnitId() {
		return this.unitsByConfigQuantityUnitId;
	}

	public void setUnitsByConfigQuantityUnitId(Units unitsByConfigQuantityUnitId) {
		this.unitsByConfigQuantityUnitId = unitsByConfigQuantityUnitId;
	}

	public Materials getMaterials() {
		return this.materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	public Formulas getFormulas() {
		return this.formulas;
	}

	public void setFormulas(Formulas formulas) {
		this.formulas = formulas;
	}

	public Units getUnitsByIncreasedQuantityUnitId() {
		return this.unitsByIncreasedQuantityUnitId;
	}

	public void setUnitsByIncreasedQuantityUnitId(
			Units unitsByIncreasedQuantityUnitId) {
		this.unitsByIncreasedQuantityUnitId = unitsByIncreasedQuantityUnitId;
	}

	public String getFormulaGroup() {
		return this.formulaGroup;
	}

	public void setFormulaGroup(String formulaGroup) {
		this.formulaGroup = formulaGroup;
	}

	public Float getMocProductQuantity() {
		return this.mocProductQuantity;
	}

	public void setMocProductQuantity(Float mocProductQuantity) {
		this.mocProductQuantity = mocProductQuantity;
	}

	public Float getConfigQuantity() {
		return this.configQuantity;
	}

	public void setConfigQuantity(Float configQuantity) {
		this.configQuantity = configQuantity;
	}

	public Float getIncreasedQuantity() {
		return this.increasedQuantity;
	}

	public void setIncreasedQuantity(Float increasedQuantity) {
		this.increasedQuantity = increasedQuantity;
	}

	public Float getDifferences() {
		return this.differences;
	}

	public void setDifferences(Float differences) {
		this.differences = differences;
	}

	public Integer getIsUseDifferences() {
		return this.isUseDifferences;
	}

	public void setIsUseDifferences(Integer isUseDifferences) {
		this.isUseDifferences = isUseDifferences;
	}

	public Float getIncreaseProportion() {
		return this.increaseProportion;
	}

	public void setIncreaseProportion(Float increaseProportion) {
		this.increaseProportion = increaseProportion;
	}

	public Integer getIsMain() {
		return this.isMain;
	}

	public void setIsMain(Integer isMain) {
		this.isMain = isMain;
	}

	public Integer getIsCalculateBalance() {
		return this.isCalculateBalance;
	}

	public void setIsCalculateBalance(Integer isCalculateBalance) {
		this.isCalculateBalance = isCalculateBalance;
	}

	public String getSupplementFormula() {
		return this.supplementFormula;
	}

	public void setSupplementFormula(String supplementFormula) {
		this.supplementFormula = supplementFormula;
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

	public Integer getPosition() {
		return this.position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

}