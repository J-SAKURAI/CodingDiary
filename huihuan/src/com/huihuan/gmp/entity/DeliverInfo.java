package com.huihuan.gmp.entity;

/**
 * DeliverInfo entity. @author MyEclipse Persistence Tools
 */

public class DeliverInfo implements java.io.Serializable {

	// Fields

	private Long id;
	private String orderId;
	private String deliverName;
	private String deliverPhone;
	private String deliverAddress;
	private String deliverCompany;
	private String deliverNum;
	private Integer hasOut;

	// Constructors

	/** default constructor */
	public DeliverInfo() {
	}

	/** full constructor */
	public DeliverInfo(String orderId, String deliverName, String deliverPhone,
			String deliverAddress, String deliverCompany, String deliverNum,
			Integer hasOut) {
		this.orderId = orderId;
		this.deliverName = deliverName;
		this.deliverPhone = deliverPhone;
		this.deliverAddress = deliverAddress;
		this.deliverCompany = deliverCompany;
		this.deliverNum = deliverNum;
		this.hasOut = hasOut;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDeliverName() {
		return this.deliverName;
	}

	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}

	public String getDeliverPhone() {
		return this.deliverPhone;
	}

	public void setDeliverPhone(String deliverPhone) {
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