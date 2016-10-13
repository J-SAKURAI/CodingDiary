package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Workshops entity. @author MyEclipse Persistence Tools
 */

public class Workshops implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set warehousesWorkshopses = new HashSet(0);
	private Set productionLineses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Workshops() {
	}

	/** minimal constructor */
	public Workshops(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public Workshops(String name, Integer status, Timestamp crtTm,
			String crtUsr, Timestamp updTm, String updUsr,
			Set warehousesWorkshopses, Set productionLineses) {
		this.name = name;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.warehousesWorkshopses = warehousesWorkshopses;
		this.productionLineses = productionLineses;
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

	public Set getWarehousesWorkshopses() {
		return this.warehousesWorkshopses;
	}

	public void setWarehousesWorkshopses(Set warehousesWorkshopses) {
		this.warehousesWorkshopses = warehousesWorkshopses;
	}

	public Set getProductionLineses() {
		return this.productionLineses;
	}

	public void setProductionLineses(Set productionLineses) {
		this.productionLineses = productionLineses;
	}

}