package com.huihuan.gmp.vo;

public class DeliveryInfoVo {

	// Fields

	private String id;
	private String goodName;
	private String deliverName;
	private Long deliverPhone;
	private String deliverAddress;
	private String deliverCompany;
	private String deliverNum;
	private Integer hasOut;

	// Constructors


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodName() {
		return this.goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	
	public String getDeliverName() {
		return this.deliverName;
	}

	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}

	public Long getDeliverPhone() {
		return this.deliverPhone;
	}

	public void setDeliverPhone(Long deliverPhone) {
		this.deliverPhone = deliverPhone;
	}

	public String getDeliverAddress() {
		return this.deliverAddress;
	}

	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress = deliverAddress;
	}

	public String getDeliverCompany() {
		return this.deliverCompany;
	}

	public void setDeliverCompany(String deliverCompany) {
		this.deliverCompany = deliverCompany;
	}

	public String getDeliverNum() {
		return this.deliverNum;
	}

	public void setDeliverNum(String deliverNum) {
		this.deliverNum = deliverNum;
	}

	public Integer getHasOut() {
		return this.hasOut;
	}

	public void setHasOut(Integer hasOut) {
		this.hasOut = hasOut;
	}

}