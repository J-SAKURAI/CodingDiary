package com.huihuan.gmp.vo;

public class ConstVo {
	private String id;
	private String mlCd;
	private String type;
	private String ky;
	private String value;
	private Integer ordr;
	public Integer getOrdr() {
		return ordr;
	}
	public void setOrdr(Integer ordr) {
		this.ordr = ordr;
	}
	public String getRmk() {
		return rmk;
	}
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	private String rmk;
	public String getMlCd() {
		return mlCd;
	}
	public void setMlCd(String mlCd) {
		this.mlCd = mlCd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKy() {
		return ky;
	}
	public void setKy(String ky) {
		this.ky = ky;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
