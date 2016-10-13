package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * UserGroups entity. @author MyEclipse Persistence Tools
 */

public class UserGroups implements java.io.Serializable {

	// Fields

	private Long id;
	private Departments departments;
	private UserGroups userGroups;
	private String name;
	private Integer type;
	private Set userGroupses = new HashSet(0);
	private Set userses = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserGroups() {
	}

	/** full constructor */
	public UserGroups(Departments departments, UserGroups userGroups,
			String name, Integer type, Set userGroupses, Set userses) {
		this.departments = departments;
		this.userGroups = userGroups;
		this.name = name;
		this.type = type;
		this.userGroupses = userGroupses;
		this.userses = userses;
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

	public UserGroups getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(UserGroups userGroups) {
		this.userGroups = userGroups;
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

	public Set getUserGroupses() {
		return this.userGroupses;
	}

	public void setUserGroupses(Set userGroupses) {
		this.userGroupses = userGroupses;
	}

	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}

}