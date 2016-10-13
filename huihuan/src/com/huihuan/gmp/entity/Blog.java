package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Blog entity. @author MyEclipse Persistence Tools
 */

public class Blog implements java.io.Serializable {

	// Fields

	private Integer blogId;
	private Userinfo userinfo;
	private String blogTitle;
	private String blogContent;
	private Integer praiseNum;
	private Integer commentNum;
	private Integer forwardNum;
	private Integer browseNum;
	private Timestamp publishTime;
	private String isLegal;
	private Integer collectNum;
	private Set tags = new HashSet(0);
	private Set userinfos = new HashSet(0);
	private Set userinfos_1 = new HashSet(0);
	private Set userinfos_2 = new HashSet(0);
	private Set usercomments = new HashSet(0);
	
	// Constructors

	/** default constructor */
	public Blog() {
	}

	/** minimal constructor */
	public Blog(String blogTitle, String blogContent) {
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
	}

	/** full constructor */
	public Blog(Userinfo userinfo, String blogTitle, String blogContent,
			Integer praiseNum, Integer commentNum, Integer forwardNum,
			Integer browseNum, Timestamp publishTime, String isLegal,
			Integer collectNum, Set tags, Set userinfos, Set userinfos_1,
			Set userinfos_2, Set usercomments) {
		this.userinfo = userinfo;
		this.blogTitle = blogTitle;
		this.blogContent = blogContent;
		this.praiseNum = praiseNum;
		this.commentNum = commentNum;
		this.forwardNum = forwardNum;
		this.browseNum = browseNum;
		this.publishTime = publishTime;
		this.isLegal = isLegal;
		this.collectNum = collectNum;
		this.tags = tags;
		this.userinfos = userinfos;
		this.userinfos_1 = userinfos_1;
		this.userinfos_2 = userinfos_2;
		this.usercomments = usercomments;
	}

	// Property accessors

	public Integer getBlogId() {
		return this.blogId;
	}

	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getBlogTitle() {
		return this.blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogContent() {
		return this.blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public Integer getPraiseNum() {
		return this.praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Integer getCommentNum() {
		return this.commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Integer getForwardNum() {
		return this.forwardNum;
	}

	public void setForwardNum(Integer forwardNum) {
		this.forwardNum = forwardNum;
	}

	public Integer getBrowseNum() {
		return this.browseNum;
	}

	public void setBrowseNum(Integer browseNum) {
		this.browseNum = browseNum;
	}

	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public String getIsLegal() {
		return this.isLegal;
	}

	public void setIsLegal(String isLegal) {
		this.isLegal = isLegal;
	}

	public Integer getCollectNum() {
		return this.collectNum;
	}

	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}

	public Set getTags() {
		return this.tags;
	}

	public void setTags(Set tags) {
		this.tags = tags;
	}

	public Set getUserinfos() {
		return this.userinfos;
	}

	public void setUserinfos(Set userinfos) {
		this.userinfos = userinfos;
	}

	public Set getUserinfos_1() {
		return this.userinfos_1;
	}

	public void setUserinfos_1(Set userinfos_1) {
		this.userinfos_1 = userinfos_1;
	}

	public Set getUserinfos_2() {
		return this.userinfos_2;
	}

	public void setUserinfos_2(Set userinfos_2) {
		this.userinfos_2 = userinfos_2;
	}

	public Set getUsercomments() {
		return this.usercomments;
	}

	public void setUsercomments(Set usercomments) {
		this.usercomments = usercomments;
	}

}