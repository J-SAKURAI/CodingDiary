package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AssemblyLines entity. @author MyEclipse Persistence Tools
 */

public class AssemblyLines implements java.io.Serializable {

	// Fields

	private Long id;
	private ProductionLines productionLines;
	private String name;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set assemblyLinesOperationRoomses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AssemblyLines() {
	}

	/** minimal constructor */
	public AssemblyLines(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public AssemblyLines(ProductionLines productionLines, String name,
			Integer status, Timestamp crtTm, String crtUsr, Timestamp updTm,
			String updUsr, Set assemblyLinesOperationRoomses) {
		this.productionLines = productionLines;
		this.name = name;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.assemblyLinesOperationRoomses = assemblyLinesOperationRoomses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductionLines getProductionLines() {
		return this.productionLines;
	}

	public void setProductionLines(ProductionLines productionLines) {
		this.productionLines = productionLines;
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

	public Set getAssemblyLinesOperationRoomses() {
		return this.assemblyLinesOperationRoomses;
	}

	public void setAssemblyLinesOperationRoomses(
			Set assemblyLinesOperationRoomses) {
		this.assemblyLinesOperationRoomses = assemblyLinesOperationRoomses;
	}

}