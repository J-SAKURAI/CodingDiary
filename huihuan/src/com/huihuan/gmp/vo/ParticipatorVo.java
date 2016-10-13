package com.huihuan.gmp.vo;

public class ParticipatorVo {
	private Long id;
	private String name;
	private String nickname;
	private Long idNum;
	private Long phoneNum;
	private Long pickupPlcaeId;
	private Long schoolId;
	private String orderId;
	private Integer autoInsert;

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

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public Long getPickupPlcaeId() {
		return this.pickupPlcaeId;
	}

	public void setPickupPlcaeId(Long pickupPlcaeId) {
		this.pickupPlcaeId = pickupPlcaeId;
	}

	public Long getSchoolId() {
		return this.schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getAutoInsert() {
		return this.autoInsert;
	}

	public void setAutoInsert(Integer autoInsert) {
		this.autoInsert = autoInsert;
	}

}
