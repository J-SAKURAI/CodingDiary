package com.huihuan.gmp.vo;

import java.sql.Timestamp;

import com.huihuan.gmp.entity.AssemblyLines;
import com.huihuan.gmp.entity.OperationRooms;

/**
 * AssemblyLinesOperationRooms entity. @author MyEclipse Persistence Tools
 */

public class AssemblyLinesOperationRoomsVo implements java.io.Serializable {

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