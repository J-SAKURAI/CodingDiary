package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Tag entity. @author MyEclipse Persistence Tools
 */

public class Tag implements java.io.Serializable {

	// Fields

	private Integer tagId;
	private String tagName;
	private Set documents = new HashSet(0);
	private Set blogs = new HashSet(0);
	private Set forumposts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tag() {
	}

	/** minimal constructor */
	public Tag(String tagName) {
		this.tagName = tagName;
	}

	/** full constructor */
	public Tag(String tagName, Set documents, Set blogs, Set forumposts) {
		this.tagName = tagName;
		this.documents = documents;
		this.blogs = blogs;
		this.forumposts = forumposts;
	}

	// Property accessors

	public Integer getTagId() {
		return this.tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Set getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set documents) {
		this.documents = documents;
	}

	public Set getBlogs() {
		return this.blogs;
	}

	public void setBlogs(Set blogs) {
		this.blogs = blogs;
	}

	public Set getForumposts() {
		return this.forumposts;
	}

	public void setForumposts(Set forumposts) {
		this.forumposts = forumposts;
	}

}