package com.huihuan.gmp.entity;

import java.sql.Timestamp;

/**
 * StoreLevel5 entity. @author MyEclipse Persistence Tools
 */

public class StoreLevel5 implements java.io.Serializable {

	// Fields

	private Long id;
	private StoreLevel4 storeLevel4;
	private String name;
	private String defineBinNo;
	private String rfidNo;
	private String number;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private String cusNumber;

	// Constructors

	/** default constructor */
	public StoreLevel5() {
	}

	/** full constructor */
	public StoreLevel5(StoreLevel4 storeLevel4, String name,
			String defineBinNo, String rfidNo, String number, Integer status,
			Timestamp crtTm, String crtUsr, Timestamp updTm, String updUsr,
			String cusNumber) {
		this.storeLevel4 = storeLevel4;
		this.name = name;
		this.defineBinNo = defineBinNo;
		this.rfidNo = rfidNo;
		this.number = number;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.cusNumber = cusNumber;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StoreLevel4 getStoreLevel4() {
		return this.storeLevel4;
	}

	public void setStoreLevel4(StoreLevel4 storeLevel4) {
		this.storeLevel4 = storeLevel4;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDefineBinNo() {
		return this.defineBinNo;
	}

	public void setDefineBinNo(String defineBinNo) {
		this.defineBinNo = defineBinNo;
	}

	public String getRfidNo() {
		return this.rfidNo;
	}

	public void setRfidNo(String rfidNo) {
		this.rfidNo = rfidNo;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public String getCusNumber() {
		return this.cusNumber;
	}

	public void setCusNumber(String cusNumber) {
		this.cusNumber = cusNumber;
	}

}