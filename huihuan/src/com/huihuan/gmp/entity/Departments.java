package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Departments entity. @author MyEclipse Persistence Tools
 */

public class Departments implements java.io.Serializable {

	// Fields

	private Long id;
	private Departments departments;
	private String code;
	private String name;
	private Set userGroupses = new HashSet(0);
	private Set userses = new HashSet(0);
	private Set employeeses = new HashSet(0);
	private Set departmentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Departments() {
	}

	/** full constructor */
	public Departments(Departments departments, String code, String name,
			Set userGroupses, Set userses, Set employeeses, Set departmentses) {
		this.departments = departments;
		this.code = code;
		this.name = name;
		this.userGroupses = userGroupses;
		this.userses = userses;
		this.employeeses = employeeses;
		this.departmentses = departmentses;
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set getEmployeeses() {
		return this.employeeses;
	}

	public void setEmployeeses(Set employeeses) {
		this.employeeses = employeeses;
	}

	public Set getDepartmentses() {
		return this.departmentses;
	}

	public void setDepartmentses(Set departmentses) {
		this.departmentses = departmentses;
	}

}