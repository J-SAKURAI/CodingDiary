package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Modules entity. @author MyEclipse Persistence Tools
 */

public class Modules implements java.io.Serializable {

	// Fields

	private Long id;
	private Modules modules;
	private String name;
	private Integer type;
	private String url;
	private Float ordr;
	private Integer isOpen2user;
	private Integer isOpen;
	private Integer isOpen2alluser;
	private String sysPropotyKey;
	private String icon;
	private Set moduleses = new HashSet(0);
	private Set moduleUserses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Modules() {
	}

	/** full constructor */
	public Modules(Modules modules, String name, Integer type, String url,
			Float ordr, Integer isOpen2user, Integer isOpen,
			Integer isOpen2alluser, String sysPropotyKey, String icon,
			Set moduleses, Set moduleUserses) {
		this.modules = modules;
		this.name = name;
		this.type = type;
		this.url = url;
		this.ordr = ordr;
		this.isOpen2user = isOpen2user;
		this.isOpen = isOpen;
		this.isOpen2alluser = isOpen2alluser;
		this.sysPropotyKey = sysPropotyKey;
		this.icon = icon;
		this.moduleses = moduleses;
		this.moduleUserses = moduleUserses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Modules getModules() {
		return this.modules;
	}

	public void setModules(Modules modules) {
		this.modules = modules;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Float getOrdr() {
		return this.ordr;
	}

	public void setOrdr(Float ordr) {
		this.ordr = ordr;
	}

	public Integer getIsOpen2user() {
		return this.isOpen2user;
	}

	public void setIsOpen2user(Integer isOpen2user) {
		this.isOpen2user = isOpen2user;
	}

	public Integer getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}

	public Integer getIsOpen2alluser() {
		return this.isOpen2alluser;
	}

	public void setIsOpen2alluser(Integer isOpen2alluser) {
		this.isOpen2alluser = isOpen2alluser;
	}

	public String getSysPropotyKey() {
		return this.sysPropotyKey;
	}

	public void setSysPropotyKey(String sysPropotyKey) {
		this.sysPropotyKey = sysPropotyKey;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Set getModuleses() {
		return this.moduleses;
	}

	public void setModuleses(Set moduleses) {
		this.moduleses = moduleses;
	}

	public Set getModuleUserses() {
		return this.moduleUserses;
	}

	public void setModuleUserses(Set moduleUserses) {
		this.moduleUserses = moduleUserses;
	}

}