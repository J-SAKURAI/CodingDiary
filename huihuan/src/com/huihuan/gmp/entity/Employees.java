package com.huihuan.gmp.entity;

import java.sql.Timestamp;

/**
 * Employees entity. @author MyEclipse Persistence Tools
 */

public class Employees implements java.io.Serializable {

	// Fields

	private Long id;
	private Departments departments;
	private String workNumber;
	private String name;
	private Integer sex;
	private String education;
	private String birthday;
	private String politicalStatus;
	private String nativePlace;
	private String address;
	private String zip;
	private String phoneNumber;
	private String mobilePhoneNumber;
	private String bankAccount;
	private String jobName;
	private Integer isSalesman;
	private String username;
	private String photoUrl;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;

	// Constructors

	/** default constructor */
	public Employees() {
	}

	/** minimal constructor */
	public Employees(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public Employees(Departments departments, String workNumber, String name,
			Integer sex, String education, String birthday,
			String politicalStatus, String nativePlace, String address,
			String zip, String phoneNumber, String mobilePhoneNumber,
			String bankAccount, String jobName, Integer isSalesman,
			String username, String photoUrl, Timestamp crtTm, String crtUsr,
			Timestamp updTm, String updUsr) {
		this.departments = departments;
		this.workNumber = workNumber;
		this.name = name;
		this.sex = sex;
		this.education = education;
		this.birthday = birthday;
		this.politicalStatus = politicalStatus;
		this.nativePlace = nativePlace;
		this.address = address;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.bankAccount = bankAccount;
		this.jobName = jobName;
		this.isSalesman = isSalesman;
		this.username = username;
		this.photoUrl = photoUrl;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Departments getDepartments() {
		return this.departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public String getWorkNumber() {
		return this.workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPoliticalStatus() {
		return this.politicalStatus;
	}

	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobilePhoneNumber() {
		return this.mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getIsSalesman() {
		return this.isSalesman;
	}

	public void setIsSalesman(Integer isSalesman) {
		this.isSalesman = isSalesman;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Timestamp getCrtTm() {
		return this.crtTm;
	}

	public void setCrtTm(Timestamp crtTm) {
		this.crtTm = crtTm;
	}

	public String getCrtUsr() {
		return this.crtUsr;
	}

	public void setCrtUsr(String crtUsr) {
		this.crtUsr = crtUsr;
	}

	public Timestamp getUpdTm() {
		return this.updTm;
	}

	public void setUpdTm(Timestamp updTm) {
		this.updTm = updTm;
	}

	public String getUpdUsr() {
		return this.updUsr;
	}

	public void setUpdUsr(String updUsr) {
		this.updUsr = updUsr;
	}

}