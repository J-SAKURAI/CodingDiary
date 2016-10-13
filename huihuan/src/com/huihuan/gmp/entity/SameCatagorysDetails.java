package com.huihuan.gmp.entity;

/**
 * SameCatagorysDetails entity. @author MyEclipse Persistence Tools
 */

public class SameCatagorysDetails implements java.io.Serializable {

	// Fields

	private Long id;
	private SameCatagories sameCatagories;
	private CatagoryDetails catagoryDetails;

	// Constructors

	/** default constructor */
	public SameCatagorysDetails() {
	}

	/** full constructor */
	public SameCatagorysDetails(SameCatagories sameCatagories,
			CatagoryDetails catagoryDetails) {
		this.sameCatagories = sameCatagories;
		this.catagoryDetails = catagoryDetails;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SameCatagories getSameCatagories() {
		return this.sameCatagories;
	}

	public void setSameCatagories(SameCatagories sameCatagories) {
		this.sameCatagories = sameCatagories;
	}

	public CatagoryDetails getCatagoryDetails() {
		return this.catagoryDetails;
	}

	public void setCatagoryDetails(CatagoryDetails catagoryDetails) {
		this.catagoryDetails = catagoryDetails;
	}

}