package com.huihuan.gmp.vo;

import java.util.List;

public class CatagoryVo {
	private Long id;
	private Integer type;
	private String name;
	private String rmk;
	private Integer ordr;
	private Integer length;
	private List catagoryDetails;
	private String codelength;
	private String tempName;
	private String tempRmk;
	private Integer tempLength;
	
	public String getTempName() {
		return tempName;
	}
	public void setTempName(String tempName) {
		this.tempName = tempName;
	}
	public String getTempRmk() {
		return tempRmk;
	}
	public void setTempRmk(String tempRmk) {
		this.tempRmk = tempRmk;
	}
	public Integer getTempLength() {
		return tempLength;
	}
	public void setTempLength(Integer tempLength) {
		this.tempLength = tempLength;
	}
	public String getCodelength() {
		return codelength;
	}
	public void setCodelength(String codelength) {
		this.codelength = codelength;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	public Integer getOrdr() {
		return ordr;
	}
	public void setOrdr(Integer ordr) {
		this.ordr = ordr;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public List getCatagoryDetails() {
		return catagoryDetails;
	}
	public void setCatagoryDetails(List catagoryDetails) {
		this.catagoryDetails = catagoryDetails;
	}
}
