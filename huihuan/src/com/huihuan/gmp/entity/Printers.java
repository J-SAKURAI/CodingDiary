package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Printers entity. @author MyEclipse Persistence Tools
 */

public class Printers implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String url;
	private Set userses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Printers() {
	}

	/** full constructor */
	public Printers(String name, String url, Set userses) {
		this.name = name;
		this.url = url;
		this.userses = userses;
	}

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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}

}