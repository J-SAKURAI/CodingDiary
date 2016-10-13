package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Warehouses entity. @author MyEclipse Persistence Tools
 */

public class Warehouses implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String code;
	private Integer type;
	private Integer ioStockWay;
	private Integer binRfidMng;
	private Integer mtrlRfidMng;
	private Integer lctnWgh;
	private Integer plnBthNumCnt;
	private Integer inventoryType;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set warehousesWorkshopses = new HashSet(0);
	private Set storeroomses = new HashSet(0);
	private Set productLinesWorkStepses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Warehouses() {
	}

	/** minimal constructor */
	public Warehouses(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public Warehouses(String name, String code, Integer type,
			Integer ioStockWay, Integer binRfidMng, Integer mtrlRfidMng,
			Integer lctnWgh, Integer plnBthNumCnt, Integer inventoryType,
			Integer status, Timestamp crtTm, String crtUsr, Timestamp updTm,
			String updUsr, Set warehousesWorkshopses, Set storeroomses,
			Set productLinesWorkStepses) {
		this.name = name;
		this.code = code;
		this.type = type;
		this.ioStockWay = ioStockWay;
		this.binRfidMng = binRfidMng;
		this.mtrlRfidMng = mtrlRfidMng;
		this.lctnWgh = lctnWgh;
		this.plnBthNumCnt = plnBthNumCnt;
		this.inventoryType = inventoryType;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.warehousesWorkshopses = warehousesWorkshopses;
		this.storeroomses = storeroomses;
		this.productLinesWorkStepses = productLinesWorkStepses;
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIoStockWay() {
		return this.ioStockWay;
	}

	public void setIoStockWay(Integer ioStockWay) {
		this.ioStockWay = ioStockWay;
	}

	public Integer getBinRfidMng() {
		return this.binRfidMng;
	}

	public void setBinRfidMng(Integer binRfidMng) {
		this.binRfidMng = binRfidMng;
	}

	public Integer getMtrlRfidMng() {
		return this.mtrlRfidMng;
	}

	public void setMtrlRfidMng(Integer mtrlRfidMng) {
		this.mtrlRfidMng = mtrlRfidMng;
	}

	public Integer getLctnWgh() {
		return this.lctnWgh;
	}

	public void setLctnWgh(Integer lctnWgh) {
		this.lctnWgh = lctnWgh;
	}

	public Integer getPlnBthNumCnt() {
		return this.plnBthNumCnt;
	}

	public void setPlnBthNumCnt(Integer plnBthNumCnt) {
		this.plnBthNumCnt = plnBthNumCnt;
	}

	public Integer getInventoryType() {
		return this.inventoryType;
	}

	public void setInventoryType(Integer inventoryType) {
		this.inventoryType = inventoryType;
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

	public Set getStoreroomses() {
		return this.storeroomses;
	}

	public void setStoreroomses(Set storeroomses) {
		this.storeroomses = storeroomses;
	}

	public Set getProductLinesWorkStepses() {
		return this.productLinesWorkStepses;
	}

	public void setProductLinesWorkStepses(Set productLinesWorkStepses) {
		this.productLinesWorkStepses = productLinesWorkStepses;
	}

}