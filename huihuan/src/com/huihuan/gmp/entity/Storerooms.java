package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Storerooms entity. @author MyEclipse Persistence Tools
 */

public class Storerooms implements java.io.Serializable {

	// Fields

	private Long id;
	private Warehouses warehouses;
	private String name;
	private String number;
	private Integer type;
	private Integer binMngWay;
	private Integer binDrpWay;
	private Integer plnrDscDsply;
	private String level3name;
	private String level4name;
	private String level5name;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set storeLevel3s = new HashSet(0);

	// Constructors

	/** default constructor */
	public Storerooms() {
	}

	/** minimal constructor */
	public Storerooms(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public Storerooms(Warehouses warehouses, String name, String number,
			Integer type, Integer binMngWay, Integer binDrpWay,
			Integer plnrDscDsply, String level3name, String level4name,
			String level5name, Integer status, Timestamp crtTm, String crtUsr,
			Timestamp updTm, String updUsr, Set storeLevel3s) {
		this.warehouses = warehouses;
		this.name = name;
		this.number = number;
		this.type = type;
		this.binMngWay = binMngWay;
		this.binDrpWay = binDrpWay;
		this.plnrDscDsply = plnrDscDsply;
		this.level3name = level3name;
		this.level4name = level4name;
		this.level5name = level5name;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.storeLevel3s = storeLevel3s;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Warehouses getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(Warehouses warehouses) {
		this.warehouses = warehouses;
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

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getBinMngWay() {
		return this.binMngWay;
	}

	public void setBinMngWay(Integer binMngWay) {
		this.binMngWay = binMngWay;
	}

	public Integer getBinDrpWay() {
		return this.binDrpWay;
	}

	public void setBinDrpWay(Integer binDrpWay) {
		this.binDrpWay = binDrpWay;
	}

	public Integer getPlnrDscDsply() {
		return this.plnrDscDsply;
	}

	public void setPlnrDscDsply(Integer plnrDscDsply) {
		this.plnrDscDsply = plnrDscDsply;
	}

	public String getLevel3name() {
		return this.level3name;
	}

	public void setLevel3name(String level3name) {
		this.level3name = level3name;
	}

	public String getLevel4name() {
		return this.level4name;
	}

	public void setLevel4name(String level4name) {
		this.level4name = level4name;
	}

	public String getLevel5name() {
		return this.level5name;
	}

	public void setLevel5name(String level5name) {
		this.level5name = level5name;
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

	public Set getStoreLevel3s() {
		return this.storeLevel3s;
	}

	public void setStoreLevel3s(Set storeLevel3s) {
		this.storeLevel3s = storeLevel3s;
	}

}