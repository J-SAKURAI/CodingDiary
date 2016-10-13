package com.huihuan.gmp.entity;

import java.sql.Timestamp;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */

public class Company implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer edId;
	private String coCustomCode;
	private String coName;
	private String isCustomer;
	private String isSupplier;
	private String supplierStatus;
	private String customerStatus;
	private String supplierAuditStatus;
	private String customerAuditStatus;
	private Integer areaId;
	private String representative;
	private String contactName;
	private String address;
	private String postalCode;
	private String phone;
	private String fax;
	private String account;
	private String taxpayerId;
	private String supplierP;
	private String supplierPra;
	private String supplierPwrap;
	private String supplierA;
	private String supplierAra;
	private String supplierAwrap;
	private String editId;
	private String editName;
	private Timestamp editDate;
	private String remark;
	private String auditId;
	private String auditName;
	private Timestamp auditDate;
	private String auditOpinion;
	private String delName;
	private String delId;
	private Timestamp delDate;
	private String isOnlyInvoiceCompany;
	private String isRa;
	private String isWrap;
	private String isHardware;
	private String isOffice;
	private String isReagent;
	private String isProd;

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** minimal constructor */
	public Company(Integer edId, String supplierStatus) {
		this.edId = edId;
		this.supplierStatus = supplierStatus;
	}

	/** full constructor */
	public Company(Integer edId, String coCustomCode, String coName,
			String isCustomer, String isSupplier, String supplierStatus,
			String customerStatus, String supplierAuditStatus,
			String customerAuditStatus, Integer areaId, String representative,
			String contactName, String address, String postalCode,
			String phone, String fax, String account, String taxpayerId,
			String supplierP, String supplierPra, String supplierPwrap,
			String supplierA, String supplierAra, String supplierAwrap,
			String editId, String editName, Timestamp editDate, String remark,
			String auditId, String auditName, Timestamp auditDate,
			String auditOpinion, String delName, String delId,
			Timestamp delDate, String isOnlyInvoiceCompany, String isRa,
			String isWrap, String isHardware, String isOffice,
			String isReagent, String isProd) {
		this.edId = edId;
		this.coCustomCode = coCustomCode;
		this.coName = coName;
		this.isCustomer = isCustomer;
		this.isSupplier = isSupplier;
		this.supplierStatus = supplierStatus;
		this.customerStatus = customerStatus;
		this.supplierAuditStatus = supplierAuditStatus;
		this.customerAuditStatus = customerAuditStatus;
		this.areaId = areaId;
		this.representative = representative;
		this.contactName = contactName;
		this.address = address;
		this.postalCode = postalCode;
		this.phone = phone;
		this.fax = fax;
		this.account = account;
		this.taxpayerId = taxpayerId;
		this.supplierP = supplierP;
		this.supplierPra = supplierPra;
		this.supplierPwrap = supplierPwrap;
		this.supplierA = supplierA;
		this.supplierAra = supplierAra;
		this.supplierAwrap = supplierAwrap;
		this.editId = editId;
		this.editName = editName;
		this.editDate = editDate;
		this.remark = remark;
		this.auditId = auditId;
		this.auditName = auditName;
		this.auditDate = auditDate;
		this.auditOpinion = auditOpinion;
		this.delName = delName;
		this.delId = delId;
		this.delDate = delDate;
		this.isOnlyInvoiceCompany = isOnlyInvoiceCompany;
		this.isRa = isRa;
		this.isWrap = isWrap;
		this.isHardware = isHardware;
		this.isOffice = isOffice;
		this.isReagent = isReagent;
		this.isProd = isProd;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEdId() {
		return this.edId;
	}

	public void setEdId(Integer edId) {
		this.edId = edId;
	}

	public String getCoCustomCode() {
		return this.coCustomCode;
	}

	public void setCoCustomCode(String coCustomCode) {
		this.coCustomCode = coCustomCode;
	}

	public String getCoName() {
		return this.coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public String getIsCustomer() {
		return this.isCustomer;
	}

	public void setIsCustomer(String isCustomer) {
		this.isCustomer = isCustomer;
	}

	public String getIsSupplier() {
		return this.isSupplier;
	}

	public void setIsSupplier(String isSupplier) {
		this.isSupplier = isSupplier;
	}

	public String getSupplierStatus() {
		return this.supplierStatus;
	}

	public void setSupplierStatus(String supplierStatus) {
		this.supplierStatus = supplierStatus;
	}

	public String getCustomerStatus() {
		return this.customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

	public String getSupplierAuditStatus() {
		return this.supplierAuditStatus;
	}

	public void setSupplierAuditStatus(String supplierAuditStatus) {
		this.supplierAuditStatus = supplierAuditStatus;
	}

	public String getCustomerAuditStatus() {
		return this.customerAuditStatus;
	}

	public void setCustomerAuditStatus(String customerAuditStatus) {
		this.customerAuditStatus = customerAuditStatus;
	}

	public Integer getAreaId() {
		return this.areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getRepresentative() {
		return this.representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getTaxpayerId() {
		return this.taxpayerId;
	}

	public void setTaxpayerId(String taxpayerId) {
		this.taxpayerId = taxpayerId;
	}

	public String getSupplierP() {
		return this.supplierP;
	}

	public void setSupplierP(String supplierP) {
		this.supplierP = supplierP;
	}

	public String getSupplierPra() {
		return this.supplierPra;
	}

	public void setSupplierPra(String supplierPra) {
		this.supplierPra = supplierPra;
	}

	public String getSupplierPwrap() {
		return this.supplierPwrap;
	}

	public void setSupplierPwrap(String supplierPwrap) {
		this.supplierPwrap = supplierPwrap;
	}

	public String getSupplierA() {
		return this.supplierA;
	}

	public void setSupplierA(String supplierA) {
		this.supplierA = supplierA;
	}

	public String getSupplierAra() {
		return this.supplierAra;
	}

	public void setSupplierAra(String supplierAra) {
		this.supplierAra = supplierAra;
	}

	public String getSupplierAwrap() {
		return this.supplierAwrap;
	}

	public void setSupplierAwrap(String supplierAwrap) {
		this.supplierAwrap = supplierAwrap;
	}

	public String getEditId() {
		return this.editId;
	}

	public void setEditId(String editId) {
		this.editId = editId;
	}

	public String getEditName() {
		return this.editName;
	}

	public void setEditName(String editName) {
		this.editName = editName;
	}

	public Timestamp getEditDate() {
		return this.editDate;
	}

	public void setEditDate(Timestamp editDate) {
		this.editDate = editDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAuditId() {
		return this.auditId;
	}

	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}

	public String getAuditName() {
		return this.auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	public Timestamp getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}

	public String getAuditOpinion() {
		return this.auditOpinion;
	}

	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}

	public String getDelName() {
		return this.delName;
	}

	public void setDelName(String delName) {
		this.delName = delName;
	}

	public String getDelId() {
		return this.delId;
	}

	public void setDelId(String delId) {
		this.delId = delId;
	}

	public Timestamp getDelDate() {
		return this.delDate;
	}

	public void setDelDate(Timestamp delDate) {
		this.delDate = delDate;
	}

	public String getIsOnlyInvoiceCompany() {
		return this.isOnlyInvoiceCompany;
	}

	public void setIsOnlyInvoiceCompany(String isOnlyInvoiceCompany) {
		this.isOnlyInvoiceCompany = isOnlyInvoiceCompany;
	}

	public String getIsRa() {
		return this.isRa;
	}

	public void setIsRa(String isRa) {
		this.isRa = isRa;
	}

	public String getIsWrap() {
		return this.isWrap;
	}

	public void setIsWrap(String isWrap) {
		this.isWrap = isWrap;
	}

	public String getIsHardware() {
		return this.isHardware;
	}

	public void setIsHardware(String isHardware) {
		this.isHardware = isHardware;
	}

	public String getIsOffice() {
		return this.isOffice;
	}

	public void setIsOffice(String isOffice) {
		this.isOffice = isOffice;
	}

	public String getIsReagent() {
		return this.isReagent;
	}

	public void setIsReagent(String isReagent) {
		this.isReagent = isReagent;
	}

	public String getIsProd() {
		return this.isProd;
	}

	public void setIsProd(String isProd) {
		this.isProd = isProd;
	}

}