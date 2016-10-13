package com.huihuan.gmp.vo;

public class PreFormulaMaterialsVo {
	String Id;
	String materialName;//原辅料名称
	String materialId;//原辅料Id
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	String PreFormulaId;//配方号
	public String getPreFormulId() {
		return PreFormulaId;
	}
	public void setPreFormulId(String preFormulId) {
		PreFormulaId = preFormulId;
	}
	String mocProductQuantity;//模拟生产量
	String configQuantity;//配置量
	String formulaGroup;//分组
	String increasedQuantity;//掺入尾料增投
	String differences;//投量差异
	String isUseDifferences;//是否启用投料差异

	public String getIsUseDifferences() {
		return isUseDifferences;
	}
	public void setIsUseDifferences(String isUseDifferences) {
		this.isUseDifferences = isUseDifferences;
	}
	String increaseProportion;//增投比例
	String isMain;//是否主药
	String isCalculateBalance;//是否计入物料平衡
	String supplementFormula;//含量补差公式
	
	private String code;//原辅料编号
	private String unit;//单位

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	
	public String getSupplementFormula() {
		return supplementFormula;
	}
	public void setSupplementFormula(String supplementFormula) {
		this.supplementFormula = supplementFormula;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getMocProductQuantity() {
		return mocProductQuantity;
	}
	public void setMocProductQuantity(String mocProductQuantity) {
		this.mocProductQuantity = mocProductQuantity;
	}
	public String getConfigQuantity() {
		return configQuantity;
	}
	public void setConfigQuantity(String configQuantity) {
		this.configQuantity = configQuantity;
	}
	public String getFormulaGroup() {
		return formulaGroup;
	}
	public void setFormulaGroup(String formulaGroup) {
		this.formulaGroup = formulaGroup;
	}
	public String getIncreasedQuantity() {
		return increasedQuantity;
	}
	public void setIncreasedQuantity(String increasedQuantity) {
		this.increasedQuantity = increasedQuantity;
	}
	public String getDifferences() {
		return differences;
	}
	public void setDifferences(String differences) {
		this.differences = differences;
	}
	public String getIncreaseProportion() {
		return increaseProportion;
	}
	public void setIncreaseProportion(String increaseProportion) {
		this.increaseProportion = increaseProportion;
	}
	public String getIsMain() {
		return isMain;
	}
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	public String getIsCalculateBalance() {
		return isCalculateBalance;
	}
	public void setIsCalculateBalance(String isCalculateBalance) {
		this.isCalculateBalance = isCalculateBalance;
	}

}
