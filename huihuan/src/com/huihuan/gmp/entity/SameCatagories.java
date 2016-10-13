package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * SameCatagories entity. @author MyEclipse Persistence Tools
 */

public class SameCatagories implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String catagoryCode;
	private String code;
	private Integer status;
	private Timestamp updTm;
	private String updUsr;
	private Set productses = new HashSet(0);
	private Set sameCatagorysDetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public SameCatagories() {
	}

	/** minimal constructor */
	public SameCatagories(Timestamp updTm) {
		this.updTm = updTm;
	}

	/** full constructor */
	public SameCatagories(String name, String catagoryCode, String code,
			Integer status, Timestamp updTm, String updUsr, Set productses,
			Set sameCatagorysDetailses) {
		this.name = name;
		this.catagoryCode = catagoryCode;
		this.code = code;
		this.status = status;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.productses = productses;
		this.sameCatagorysDetailses = sameCatagorysDetailses;
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

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Set getProductses() {
		return this.productses;
	}

	public void setProductses(Set productses) {
		this.productses = productses;
	}

	public Set getSameCatagorysDetailses() {
		return this.sameCatagorysDetailses;
	}

	public void setSameCatagorysDetailses(Set sameCatagorysDetailses) {
		this.sameCatagorysDetailses = sameCatagorysDetailses;
	}

}