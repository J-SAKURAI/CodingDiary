package com.huihuan.gmp.vo;

import com.huihuan.gmp.entity.Materials;
import com.huihuan.gmp.entity.PreFormulas;

public class PreFormulaMaterialVo {
	private Long id;
	//private PreFormulas preFormulas;
	private String materialsName;  //原辅料名称
	private String formulaGroup;   //配方分组
	private Float mocProductQuantity;//模拟生产量
	private Float configQuantity;//配置量
	private Float increasedQuantity;//掺入尾料增投
	private Float differences;//投量差异
	private Integer isUseDifferences;
	private Float increaseProportion;//增投比例
	private Integer isMain;//是否主药
	private Integer isCalculateBalance;//是否计入物料平衡

	private String code;//原辅料编号
	private String unit;//单位
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMaterialsName() {
		return materialsName;
	}
	public void setMaterialsName(String materialsName) {
		this.materialsName = materialsName;
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
}
