package com.huihuan.gmp.entity;

/**
 * Const entity. @author MyEclipse Persistence Tools
 */

public class Const implements java.io.Serializable {

	// Fields

	private Long id;
	private String constantName;
	private String content;

	// Constructors

	/** default constructor */
	public Const() {
	}

	/** full constructor */
	public Const(String constantName, String content) {
		this.constantName = constantName;
		this.content = content;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConstantName() {
		return this.constantName;
	}

	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}