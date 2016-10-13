package com.huihuan.gmp.entity;

/**
 * ModuleUsers entity. @author MyEclipse Persistence Tools
 */

public class ModuleUsers implements java.io.Serializable {

	// Fields

	private Long id;
	private Users users;
	private Modules modules;
	private Integer type;

	// Constructors

	/** default constructor */
	public ModuleUsers() {
	}

	/** full constructor */
	public ModuleUsers(Users users, Modules modules, Integer type) {
		this.users = users;
		this.modules = modules;
		this.type = type;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Modules getModules() {
		return this.modules;
	}

	public void setModules(Modules modules) {
		this.modules = modules;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}