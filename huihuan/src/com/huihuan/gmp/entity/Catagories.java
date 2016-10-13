package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Catagories entity. @author MyEclipse Persistence Tools
 */

public class Catagories implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer type;
	private String name;
	private String tempName;
	private String rmk;
	private String tempRmk;
	private Integer ordr;
	private Integer length;
	private Integer tempLength;
	private Integer status;
	private Set catagoryDetailses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Catagories() {
	}

	/** full constructor */
	public Catagories(Integer type, String name, String tempName, String rmk,
			String tempRmk, Integer ordr, Integer length, Integer tempLength,
			Integer status, Set catagoryDetailses) {
		this.type = type;
		this.name = name;
		this.tempName = tempName;
		this.rmk = rmk;
		this.tempRmk = tempRmk;
		this.ordr = ordr;
		this.length = length;
		this.tempLength = tempLength;
		this.status = status;
		this.catagoryDetailses = catagoryDetailses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTempName() {
		return this.tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public String getRmk() {
		return this.rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getTempRmk() {
		return this.tempRmk;
	}

	public void setTempRmk(String tempRmk) {
		this.tempRmk = tempRmk;
	}

	public Integer getOrdr() {
		return this.ordr;
	}

	public void setOrdr(Integer ordr) {
		this.ordr = ordr;
	}

	public Integer getLength() {
		return this.length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getTempLength() {
		return this.tempLength;
	}

	public void setTempLength(Integer tempLength) {
		this.tempLength = tempLength;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getCatagoryDetailses() {
		return this.catagoryDetailses;
	}

	public void setCatagoryDetailses(Set catagoryDetailses) {
		this.catagoryDetailses = catagoryDetailses;
	}

}