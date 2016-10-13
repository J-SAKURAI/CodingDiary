package com.huihuan.gmp.entity;

/**
 * MaterialCatagoryDetails entity. @author MyEclipse Persistence Tools
 */

public class MaterialCatagoryDetails implements java.io.Serializable {

	// Fields

	private Long id;
	private Materials materials;
	private CatagoryDetails catagoryDetails;

	// Constructors

	/** default constructor */
	public MaterialCatagoryDetails() {
	}

	/** full constructor */
	public MaterialCatagoryDetails(Materials materials,
			CatagoryDetails catagoryDetails) {
		this.materials = materials;
		this.catagoryDetails = catagoryDetails;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Materials getMaterials() {
		return this.materials;
	}

	public void setMaterials(Materials materials) {
		this.materials = materials;
	}

	public CatagoryDetails getCatagoryDetails() {
		return this.catagoryDetails;
	}

	public void setCatagoryDetails(CatagoryDetails catagoryDetails) {
		this.catagoryDetails = catagoryDetails;
	}

}