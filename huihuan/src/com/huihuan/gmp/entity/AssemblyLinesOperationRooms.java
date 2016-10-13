package com.huihuan.gmp.entity;

import java.sql.Timestamp;

/**
 * AssemblyLinesOperationRooms entity. @author MyEclipse Persistence Tools
 */

public class AssemblyLinesOperationRooms implements java.io.Serializable {

	// Fields

	private Long id;
	private OperationRooms operationRooms;
	private AssemblyLines assemblyLines;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;

	// Constructors

	/** default constructor */
	public AssemblyLinesOperationRooms() {
	}

	/** minimal constructor */
	public AssemblyLinesOperationRooms(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public AssemblyLinesOperationRooms(OperationRooms operationRooms,
			AssemblyLines assemblyLines, Integer status, Timestamp crtTm,
			String crtUsr, Timestamp updTm, String updUsr) {
		this.operationRooms = operationRooms;
		this.assemblyLines = assemblyLines;
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

	public OperationRooms getOperationRooms() {
		return this.operationRooms;
	}

	public void setOperationRooms(OperationRooms operationRooms) {
		this.operationRooms = operationRooms;
	}

	public AssemblyLines getAssemblyLines() {
		return this.assemblyLines;
	}

	public void setAssemblyLines(AssemblyLines assemblyLines) {
		this.assemblyLines = assemblyLines;
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