package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * CatagoryDetails entity. @author MyEclipse Persistence Tools
 */

public class CatagoryDetails implements java.io.Serializable {

	// Fields

	private Long id;
	private Catagories catagories;
	private String code;
	private String name;
	private Timestamp updTm;
	private String updUsr;
	private Set wrapperCatagoryDetailses = new HashSet(0);
	private Set sameCatagorysDetailses = new HashSet(0);
	private Set materialCatagoryDetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public CatagoryDetails() {
	}

	/** minimal constructor */
	public CatagoryDetails(Timestamp updTm) {
		this.updTm = updTm;
	}

	/** full constructor */
	public CatagoryDetails(Catagories catagories, String code, String name,
			Timestamp updTm, String updUsr, Set wrapperCatagoryDetailses,
			Set sameCatagorysDetailses, Set materialCatagoryDetailses) {
		this.catagories = catagories;
		this.code = code;
		this.name = name;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.wrapperCatagoryDetailses = wrapperCatagoryDetailses;
		this.sameCatagorysDetailses = sameCatagorysDetailses;
		this.materialCatagoryDetailses = materialCatagoryDetailses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Catagories getCatagories() {
		return this.catagories;
	}

	public void setCatagories(Catagories catagories) {
		this.catagories = catagories;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set getWrapperCatagoryDetailses() {
		return this.wrapperCatagoryDetailses;
	}

	public void setWrapperCatagoryDetailses(Set wrapperCatagoryDetailses) {
		this.wrapperCatagoryDetailses = wrapperCatagoryDetailses;
	}

	public Set getSameCatagorysDetailses() {
		return this.sameCatagorysDetailses;
	}

	public void setSameCatagorysDetailses(Set sameCatagorysDetailses) {
		this.sameCatagorysDetailses = sameCatagorysDetailses;
	}

	public Set getMaterialCatagoryDetailses() {
		return this.materialCatagoryDetailses;
	}

	public void setMaterialCatagoryDetailses(Set materialCatagoryDetailses) {
		this.materialCatagoryDetailses = materialCatagoryDetailses;
	}

}