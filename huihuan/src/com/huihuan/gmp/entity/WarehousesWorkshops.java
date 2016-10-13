package com.huihuan.gmp.entity;

import java.sql.Timestamp;

/**
 * WarehousesWorkshops entity. @author MyEclipse Persistence Tools
 */

public class WarehousesWorkshops implements java.io.Serializable {

	// Fields

	private Long id;
	private Workshops workshops;
	private Warehouses warehouses;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;

	// Constructors

	/** default constructor */
	public WarehousesWorkshops() {
	}

	/** minimal constructor */
	public WarehousesWorkshops(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public WarehousesWorkshops(Workshops workshops, Warehouses warehouses,
			Integer status, Timestamp crtTm, String crtUsr, Timestamp updTm,
			String updUsr) {
		this.workshops = workshops;
		this.warehouses = warehouses;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
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

	public Warehouses getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(Warehouses warehouses) {
		this.warehouses = warehouses;
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

}