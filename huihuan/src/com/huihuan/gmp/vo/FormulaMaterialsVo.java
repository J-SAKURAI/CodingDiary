package com.huihuan.gmp.vo;

public class FormulaMaterialsVo {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getFormulaId() {
		return formulaId;
	}
	public void setFormulaId(Long formulaId) {
		this.formulaId = formulaId;
	}
	public Long getMaterialId() {
		return materialId;
	}
	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getFormulaGroup() {
		return formulaGroup;
	}
	public void setFormulaGroup(String formulaGroup) {
		this.formulaGroup = formulaGroup;
	}
	public Float getMocProductQuantity() {
		return mocProductQuantity;
	}
	public void setMocProductQuantity(Float mocProductQuantity) {
		this.mocProductQuantity = mocProductQuantity;
	}
	public Float getConfigQuantity() {
		return configQuantity;
	}
	public void setConfigQuantity(Float configQuantity) {
		this.configQuantity = configQuantity;
	}
	public Float getIncreasedQuantity() {
		return increasedQuantity;
	}
	public void setIncreasedQuantity(Float increasedQuantity) {
		this.increasedQuantity = increasedQuantity;
	}
	public Float getDifferences() {
		return differences;
	}
	public void setDifferences(Float differences) {
		this.differences = differences;
	}
	public Integer getIsUseDifferences() {
		return isUseDifferences;
	}
	public void setIsUseDifferences(Integer isUseDifferences) {
		this.isUseDifferences = isUseDifferences;
	}
	public Float getIncreaseProportion() {
		return increaseProportion;
	}
	public void setIncreaseProportion(Float increaseProportion) {
		this.increaseProportion = increaseProportion;
	}
	public Integer getIsMain() {
		return isMain;
	}
	public void setIsMain(Integer isMain) {
		this.isMain = isMain;
	}
	public Integer getIsCalculateBalance() {
		return isCalculateBalance;
	}
	public void setIsCalculateBalance(Integer isCalculateBalance) {
		this.isCalculateBalance = isCalculateBalance;
	}
	public String getSupplementFormula() {
		return supplementFormula;
	}
	public void setSupplementFormula(String supplementFormula) {
		this.supplementFormula = supplementFormula;
	}
	public String getMaterialUnit() {
		return materialUnit;
	}
	public void setMaterialUnit(String materialUnit) {
		this.materialUnit = materialUnit;
	}
	private Long id;
	private Long formulaId;
	private Long materialId;
	private String materialName;
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
	private String materialUnit;


}
