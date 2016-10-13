package com.huihuan.gmp.entity;

/**
 * SysProperty entity. @author MyEclipse Persistence Tools
 */

public class SysProperty implements java.io.Serializable {

	// Fields

	private Long id;
	private String mdlCd;
	private String propotyKey;
	private String propotyVl;
	private String rmk;

	// Constructors

	/** default constructor */
	public SysProperty() {
	}

	/** full constructor */
	public SysProperty(String mdlCd, String propotyKey, String propotyVl,
			String rmk) {
		this.mdlCd = mdlCd;
		this.propotyKey = propotyKey;
		this.propotyVl = propotyVl;
		this.rmk = rmk;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMdlCd() {
		return this.mdlCd;
	}

	public void setMdlCd(String mdlCd) {
		this.mdlCd = mdlCd;
	}

	public String getPropotyKey() {
		return this.propotyKey;
	}

	public void setPropotyKey(String propotyKey) {
		this.propotyKey = propotyKey;
	}

	public String getPropotyVl() {
		return this.propotyVl;
	}

	public void setPropotyVl(String propotyVl) {
		this.propotyVl = propotyVl;
	}

	public String getRmk() {
		return this.rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

}