package com.huihuan.gmp.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.huihuan.gmp.entity.ProductLinesWorkSteps;

/**
 * OperationRooms entity. @author MyEclipse Persistence Tools
 */

public class OperationRoomsVo{

	// Fields

	private Long id;
	private ProductLinesWorkSteps productLinesWorkSteps;
	private String name;
	private Integer sonRoom;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set assemblyLinesOperationRoomses = new HashSet(0);

	// Constructors

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductLinesWorkSteps getProductLinesWorkSteps() {
		return this.productLinesWorkSteps;
	}

	public void setProductLinesWorkSteps(
			ProductLinesWorkSteps productLinesWorkSteps) {
		this.productLinesWorkSteps = productLinesWorkSteps;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSonRoom() {
		return this.sonRoom;
	}

	public void setSonRoom(Integer sonRoom) {
		this.sonRoom = sonRoom;
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