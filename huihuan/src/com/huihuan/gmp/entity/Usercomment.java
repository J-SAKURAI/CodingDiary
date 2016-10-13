package com.huihuan.gmp.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Usercomment entity. @author MyEclipse Persistence Tools
 */

public class Usercomment implements java.io.Serializable {

	// Fields

	private Integer commentId;
	private Userinfo userinfo;
	private String commentContent;
	private Integer praiseNum;
	private Set userinfos = new HashSet(0);
	private Set forumposts = new HashSet(0);
	private Set documents = new HashSet(0);
	private Set blogs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Usercomment() {
	}

	/** minimal constructor */
	public Usercomment(String commentContent) {
		this.commentContent = commentContent;
	}

	/** full constructor */
	public Usercomment(Userinfo userinfo, String commentContent,
			Integer praiseNum, Set userinfos, Set forumposts, Set documents,
			Set blogs) {
		this.userinfo = userinfo;
		this.commentContent = commentContent;
		this.praiseNum = praiseNum;
		this.userinfos = userinfos;
		this.forumposts = forumposts;
		this.documents = documents;
		this.blogs = blogs;
	}

	// Property accessors

	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getCommentContent() {
		return this.commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Integer getPraiseNum() {
		return this.praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Set getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set userinfos) {
		this.userinfos = userinfos;
	}

	public Set getForumposts() {
		return this.forumposts;
	}

	public void setForumposts(Set forumposts) {
		this.forumposts = forumposts;
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

}