package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Units entity. @author MyEclipse Persistence Tools
 */

public class Units implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Integer type;
	private Float proportion;
	private Set materialsesForQuantityUnitId2 = new HashSet(0);
	private Set materialsesForQuantityUnitId1 = new HashSet(0);
	private Set wrappersesForBaseQuantityUnitId = new HashSet(0);
	private Set materialsesForBaseQuantityUnitId = new HashSet(0);
	private Set formulaMaterialsesForConfigQuantityUnitId = new HashSet(0);
	private Set formulaMaterialsesForIncreasedQuantityUnitId = new HashSet(0);
	private Set productsesForQuantityUnitId2 = new HashSet(0);
	private Set preFormulaMaterialsesForIncreasedQuantityUnitId = new HashSet(0);
	private Set wrappersesForQuantityUnitId1 = new HashSet(0);
	private Set wrappersesForQuantityUnitId2 = new HashSet(0);
	private Set productsesForBaseQuantityUnitId = new HashSet(0);
	private Set preFormulaMaterialsesForConfigQuantityUnitId = new HashSet(0);
	private Set productsesForQuantityUnitId1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Units() {
	}

	/** full constructor */
	public Units(String name, Integer type, Float proportion,
			Set materialsesForQuantityUnitId2,
			Set materialsesForQuantityUnitId1,
			Set wrappersesForBaseQuantityUnitId,
			Set materialsesForBaseQuantityUnitId,
			Set formulaMaterialsesForConfigQuantityUnitId,
			Set formulaMaterialsesForIncreasedQuantityUnitId,
			Set productsesForQuantityUnitId2,
			Set preFormulaMaterialsesForIncreasedQuantityUnitId,
			Set wrappersesForQuantityUnitId1, Set wrappersesForQuantityUnitId2,
			Set productsesForBaseQuantityUnitId,
			Set preFormulaMaterialsesForConfigQuantityUnitId,
			Set productsesForQuantityUnitId1) {
		this.name = name;
		this.type = type;
		this.proportion = proportion;
		this.materialsesForQuantityUnitId2 = materialsesForQuantityUnitId2;
		this.materialsesForQuantityUnitId1 = materialsesForQuantityUnitId1;
		this.wrappersesForBaseQuantityUnitId = wrappersesForBaseQuantityUnitId;
		this.materialsesForBaseQuantityUnitId = materialsesForBaseQuantityUnitId;
		this.formulaMaterialsesForConfigQuantityUnitId = formulaMaterialsesForConfigQuantityUnitId;
		this.formulaMaterialsesForIncreasedQuantityUnitId = formulaMaterialsesForIncreasedQuantityUnitId;
		this.productsesForQuantityUnitId2 = productsesForQuantityUnitId2;
		this.preFormulaMaterialsesForIncreasedQuantityUnitId = preFormulaMaterialsesForIncreasedQuantityUnitId;
		this.wrappersesForQuantityUnitId1 = wrappersesForQuantityUnitId1;
		this.wrappersesForQuantityUnitId2 = wrappersesForQuantityUnitId2;
		this.productsesForBaseQuantityUnitId = productsesForBaseQuantityUnitId;
		this.preFormulaMaterialsesForConfigQuantityUnitId = preFormulaMaterialsesForConfigQuantityUnitId;
		this.productsesForQuantityUnitId1 = productsesForQuantityUnitId1;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Float getProportion() {
		return this.proportion;
	}

	public void setProportion(Float proportion) {
		this.proportion = proportion;
	}

	public Set getMaterialsesForQuantityUnitId2() {
		return this.materialsesForQuantityUnitId2;
	}

	public void setMaterialsesForQuantityUnitId2(
			Set materialsesForQuantityUnitId2) {
		this.materialsesForQuantityUnitId2 = materialsesForQuantityUnitId2;
	}

	public Set getMaterialsesForQuantityUnitId1() {
		return this.materialsesForQuantityUnitId1;
	}

	public void setMaterialsesForQuantityUnitId1(
			Set materialsesForQuantityUnitId1) {
		this.materialsesForQuantityUnitId1 = materialsesForQuantityUnitId1;
	}

	public Set getWrappersesForBaseQuantityUnitId() {
		return this.wrappersesForBaseQuantityUnitId;
	}

	public void setWrappersesForBaseQuantityUnitId(
			Set wrappersesForBaseQuantityUnitId) {
		this.wrappersesForBaseQuantityUnitId = wrappersesForBaseQuantityUnitId;
	}

	public Set getMaterialsesForBaseQuantityUnitId() {
		return this.materialsesForBaseQuantityUnitId;
	}

	public void setMaterialsesForBaseQuantityUnitId(
			Set materialsesForBaseQuantityUnitId) {
		this.materialsesForBaseQuantityUnitId = materialsesForBaseQuantityUnitId;
	}

	public Set getFormulaMaterialsesForConfigQuantityUnitId() {
		return this.formulaMaterialsesForConfigQuantityUnitId;
	}

	public void setFormulaMaterialsesForConfigQuantityUnitId(
			Set formulaMaterialsesForConfigQuantityUnitId) {
		this.formulaMaterialsesForConfigQuantityUnitId = formulaMaterialsesForConfigQuantityUnitId;
	}

	public Set getFormulaMaterialsesForIncreasedQuantityUnitId() {
		return this.formulaMaterialsesForIncreasedQuantityUnitId;
	}

	public void setFormulaMaterialsesForIncreasedQuantityUnitId(
			Set formulaMaterialsesForIncreasedQuantityUnitId) {
		this.formulaMaterialsesForIncreasedQuantityUnitId = formulaMaterialsesForIncreasedQuantityUnitId;
	}

	public Set getProductsesForQuantityUnitId2() {
		return this.productsesForQuantityUnitId2;
	}

	public void setProductsesForQuantityUnitId2(Set productsesForQuantityUnitId2) {
		this.productsesForQuantityUnitId2 = productsesForQuantityUnitId2;
	}

	public Set getPreFormulaMaterialsesForIncreasedQuantityUnitId() {
		return this.preFormulaMaterialsesForIncreasedQuantityUnitId;
	}

	public void setPreFormulaMaterialsesForIncreasedQuantityUnitId(
			Set preFormulaMaterialsesForIncreasedQuantityUnitId) {
		this.preFormulaMaterialsesForIncreasedQuantityUnitId = preFormulaMaterialsesForIncreasedQuantityUnitId;
	}

	public Set getWrappersesForQuantityUnitId1() {
		return this.wrappersesForQuantityUnitId1;
	}

	public void setWrappersesForQuantityUnitId1(Set wrappersesForQuantityUnitId1) {
		this.wrappersesForQuantityUnitId1 = wrappersesForQuantityUnitId1;
	}

	public Set getWrappersesForQuantityUnitId2() {
		return this.wrappersesForQuantityUnitId2;
	}

	public void setWrappersesForQuantityUnitId2(Set wrappersesForQuantityUnitId2) {
		this.wrappersesForQuantityUnitId2 = wrappersesForQuantityUnitId2;
	}

	public Set getProductsesForBaseQuantityUnitId() {
		return this.productsesForBaseQuantityUnitId;
	}

	public void setProductsesForBaseQuantityUnitId(
			Set productsesForBaseQuantityUnitId) {
		this.productsesForBaseQuantityUnitId = productsesForBaseQuantityUnitId;
	}

	public Set getPreFormulaMaterialsesForConfigQuantityUnitId() {
		return this.preFormulaMaterialsesForConfigQuantityUnitId;
	}

	public void setPreFormulaMaterialsesForConfigQuantityUnitId(
			Set preFormulaMaterialsesForConfigQuantityUnitId) {
		this.preFormulaMaterialsesForConfigQuantityUnitId = preFormulaMaterialsesForConfigQuantityUnitId;
	}

	public Set getProductsesForQuantityUnitId1() {
		return this.productsesForQuantityUnitId1;
	}

	public void setProductsesForQuantityUnitId1(Set productsesForQuantityUnitId1) {
		this.productsesForQuantityUnitId1 = productsesForQuantityUnitId1;
	}

}