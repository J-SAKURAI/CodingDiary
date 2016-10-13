package com.huihuan.gmp.vo;

import java.sql.Timestamp;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.huihuan.gmp.entity.Warehouses;

public class StoreroomVo {
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Warehouses getWarehouses() {
		return warehouses;
	}
	public void setWarehouses(Warehouses warehouses) {
		this.warehouses = warehouses;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getBinMngWay() {
		return binMngWay;
	}
	public void setBinMngWay(Integer binMngWay) {
		this.binMngWay = binMngWay;
	}
	public Integer getBinDrpWay() {
		return binDrpWay;
	}
	public void setBinDrpWay(Integer binDrpWay) {
		this.binDrpWay = binDrpWay;
	}
	public Integer getPlnrDscDsply() {
		return plnrDscDsply;
	}
	public void setPlnrDscDsply(Integer plnrDscDsply) {
		this.plnrDscDsply = plnrDscDsply;
	}
	public String getLevel3name() {
		return level3name;
	}
	public void setLevel3name(String level3name) {
		this.level3name = level3name;
	}
	public String getLevel4name() {
		return level4name;
	}
	public void setLevel4name(String level4name) {
		this.level4name = level4name;
	}
	public String getLevel5name() {
		return level5name;
	}
	public void setLevel5name(String level5name) {
		this.level5name = level5name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getCrtTm() {
		return crtTm;
	}
	public void setCrtTm(Timestamp crtTm) {
		this.crtTm = crtTm;
	}
	public String getCrtUsr() {
		return crtUsr;
	}
	public void setCrtUsr(String crtUsr) {
		this.crtUsr = crtUsr;
	}
	public Timestamp getUpdTm() {
		return updTm;
	}
	public void setUpdTm(Timestamp updTm) {
		this.updTm = updTm;
	}
	public String getUpdUsr() {
		return updUsr;
	}
	public void setUpdUsr(String updUsr) {
		this.updUsr = updUsr;
	}
}
