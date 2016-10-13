package com.huihuan.gmp.entity;

/**
 * WrapperCatagoryDetails entity. @author MyEclipse Persistence Tools
 */

public class WrapperCatagoryDetails implements java.io.Serializable {

	// Fields

	private Long id;
	private Wrappers wrappers;
	private CatagoryDetails catagoryDetails;

	// Constructors

	/** default constructor */
	public WrapperCatagoryDetails() {
	}

	/** full constructor */
	public WrapperCatagoryDetails(Wrappers wrappers,
			CatagoryDetails catagoryDetails) {
		this.wrappers = wrappers;
		this.catagoryDetails = catagoryDetails;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Wrappers getWrappers() {
		return this.wrappers;
	}

	public void setWrappers(Wrappers wrappers) {
		this.wrappers = wrappers;
	}

	public CatagoryDetails getCatagoryDetails() {
		return this.catagoryDetails;
	}

	public void setCatagoryDetails(CatagoryDetails catagoryDetails) {
		this.catagoryDetails = catagoryDetails;
	}

}