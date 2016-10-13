package com.huihuan.gmp.vo;

public class TotalQuitInfoVo {

	// Fields

	private Long id;
	private String title;
	private String name;
	private Long idNum;
	private Long phoneNum;
	private Integer status;
	private String quitReason;

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

	public Long getIdNum() {
		return this.idNum;
	}

	public void setIdNum(Long idNum) {
		this.idNum = idNum;
	}

	public Long getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title= title;
	}
	
	public String getQuitReason() {
		return this.quitReason;
	}

	public void setQuitReason(String quitReason) {
		this.quitReason= quitReason;
	}


	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}