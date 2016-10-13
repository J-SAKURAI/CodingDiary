package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ProductionLines entity. @author MyEclipse Persistence Tools
 */

public class ProductionLines implements java.io.Serializable {

	// Fields

	private Long id;
	private Workshops workshops;
	private Crafts crafts;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set productLinesWorkStepses = new HashSet(0);
	private Set assemblyLineses = new HashSet(0);

	// Constructors

	/** default constructor */
	public ProductionLines() {
	}

	/** minimal constructor */
	public ProductionLines(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public ProductionLines(Workshops workshops, Crafts crafts, Integer status,
			Timestamp crtTm, String crtUsr, Timestamp updTm, String updUsr,
			Set productLinesWorkStepses, Set assemblyLineses) {
		this.workshops = workshops;
		this.crafts = crafts;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.productLinesWorkStepses = productLinesWorkStepses;
		this.assemblyLineses = assemblyLineses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Workshops getWorkshops() {
		return this.workshops;
	}

	public void setWorkshops(Workshops workshops) {
		this.workshops = workshops;
	}

	public Crafts getCrafts() {
		return this.crafts;
	}

	public void setCrafts(Crafts crafts) {
		this.crafts = crafts;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCrtTm() {
		return this.crtTm;
	}

	public void setCrtTm(Timestamp crtTm) {
		this.crtTm = crtTm;
	}

	public String getCrtUsr() {
		return this.crtUsr;
	}

	public void setCrtUsr(String crtUsr) {
		this.crtUsr = crtUsr;
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

	public Set getProductLinesWorkStepses() {
		return this.productLinesWorkStepses;
	}

	public void setProductLinesWorkStepses(Set productLinesWorkStepses) {
		this.productLinesWorkStepses = productLinesWorkStepses;
	}

	public Set getAssemblyLineses() {
		return this.assemblyLineses;
	}

	public void setAssemblyLineses(Set assemblyLineses) {
		this.assemblyLineses = assemblyLineses;
	}

}