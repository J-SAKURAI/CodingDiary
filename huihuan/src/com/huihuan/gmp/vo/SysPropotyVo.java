package com.huihuan.gmp.vo;

public class SysPropotyVo {
	private Long id;
	private String mlCd;
	private String type;
	private String ky;
	private String value;
	private String ordr;
	public String getOrdr() {
		return ordr;
	}
	public void setOrdr(String ordr) {
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
