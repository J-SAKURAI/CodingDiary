package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Long id;
	private Printers printers;
	private Departments departments;
	private UserGroups userGroups;
	private String username;
	private String password;
	private String name;
	private String rmk;
	private String cardId;
	private String cardCode;
	private Integer type;
	private Integer status;
	private Integer menuStyle;
	private Integer toolBar;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set receiveMailses = new HashSet(0);
	private Set repairsesForHandleUserId = new HashSet(0);
	private Set mailses = new HashSet(0);
	private Set moduleUserses = new HashSet(0);
	private Set repairsesForSubmitUserId = new HashSet(0);
	private Set repairsesForConfirmUserId = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public Users(Printers printers, Departments departments,
			UserGroups userGroups, String username, String password,
			String name, String rmk, String cardId, String cardCode,
			Integer type, Integer status, Integer menuStyle, Integer toolBar,
			Timestamp crtTm, String crtUsr, Timestamp updTm, String updUsr,
			Set receiveMailses, Set repairsesForHandleUserId, Set mailses,
			Set moduleUserses, Set repairsesForSubmitUserId,
			Set repairsesForConfirmUserId) {
		this.printers = printers;
		this.departments = departments;
		this.userGroups = userGroups;
		this.username = username;
		this.password = password;
		this.name = name;
		this.rmk = rmk;
		this.cardId = cardId;
		this.cardCode = cardCode;
		this.type = type;
		this.status = status;
		this.menuStyle = menuStyle;
		this.toolBar = toolBar;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.receiveMailses = receiveMailses;
		this.repairsesForHandleUserId = repairsesForHandleUserId;
		this.mailses = mailses;
		this.moduleUserses = moduleUserses;
		this.repairsesForSubmitUserId = repairsesForSubmitUserId;
		this.repairsesForConfirmUserId = repairsesForConfirmUserId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Printers getPrinters() {
		return this.printers;
	}

	public void setPrinters(Printers printers) {
		this.printers = printers;
	}

	public Departments getDepartments() {
		return this.departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public UserGroups getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(UserGroups userGroups) {
		this.userGroups = userGroups;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRmk() {
		return this.rmk;
	}

	public void setRmk(String rmk) {
		this.rmk = rmk;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardCode() {
		return this.cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getMenuStyle() {
		return this.menuStyle;
	}

	public void setMenuStyle(Integer menuStyle) {
		this.menuStyle = menuStyle;
	}

	public Integer getToolBar() {
		return this.toolBar;
	}

	public void setToolBar(Integer toolBar) {
		this.toolBar = toolBar;
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

	public Set getReceiveMailses() {
		return this.receiveMailses;
	}

	public void setReceiveMailses(Set receiveMailses) {
		this.receiveMailses = receiveMailses;
	}

	public Set getRepairsesForHandleUserId() {
		return this.repairsesForHandleUserId;
	}

	public void setRepairsesForHandleUserId(Set repairsesForHandleUserId) {
		this.repairsesForHandleUserId = repairsesForHandleUserId;
	}

	public Set getMailses() {
		return this.mailses;
	}

	public void setMailses(Set mailses) {
		this.mailses = mailses;
	}

	public Set getModuleUserses() {
		return this.moduleUserses;
	}

	public void setModuleUserses(Set moduleUserses) {
		this.moduleUserses = moduleUserses;
	}

	public Set getRepairsesForSubmitUserId() {
		return this.repairsesForSubmitUserId;
	}

	public void setRepairsesForSubmitUserId(Set repairsesForSubmitUserId) {
		this.repairsesForSubmitUserId = repairsesForSubmitUserId;
	}

	public Set getRepairsesForConfirmUserId() {
		return this.repairsesForConfirmUserId;
	}

	public void setRepairsesForConfirmUserId(Set repairsesForConfirmUserId) {
		this.repairsesForConfirmUserId = repairsesForConfirmUserId;
	}

}