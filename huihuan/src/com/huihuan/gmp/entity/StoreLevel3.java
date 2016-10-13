package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * StoreLevel3 entity. @author MyEclipse Persistence Tools
 */

public class StoreLevel3 implements java.io.Serializable {

	// Fields

	private Long id;
	private Storerooms storerooms;
	private String name;
	private String number;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set storeLevel4s = new HashSet(0);

	// Constructors

	/** default constructor */
	public StoreLevel3() {
	}

	/** minimal constructor */
	public StoreLevel3(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public StoreLevel3(Storerooms storerooms, String name, String number,
			Integer status, Timestamp crtTm, String crtUsr, Timestamp updTm,
			String updUsr, Set storeLevel4s) {
		this.storerooms = storerooms;
		this.name = name;
		this.number = number;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.storeLevel4s = storeLevel4s;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Storerooms getStorerooms() {
		return this.storerooms;
	}

	public void setStorerooms(Storerooms storerooms) {
		this.storerooms = storerooms;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set getStoreLevel4s() {
		return this.storeLevel4s;
	}

	public void setStoreLevel4s(Set storeLevel4s) {
		this.storeLevel4s = storeLevel4s;
	}

}