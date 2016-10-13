package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Forumpost entity. @author MyEclipse Persistence Tools
 */

public class Forumpost implements java.io.Serializable {

	// Fields

	private Integer postId;
	private Userinfo userinfo;
	private String postTitle;
	private String postContent;
	private Integer praiseNum;
	private Integer forwardNum;
	private Integer commentNum;
	private Integer browseNum;
	private Timestamp publishTime;
	private String isLegal;
	private Integer collectNum;
	private Set userinfos = new HashSet(0);
	private Set userinfos_1 = new HashSet(0);
	private Set usercomments = new HashSet(0);
	private Set tags = new HashSet(0);
	private Set userinfos_2 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Forumpost() {
	}

	/** minimal constructor */
	public Forumpost(String postTitle, String postContent) {
		this.postTitle = postTitle;
		this.postContent = postContent;
	}

	/** full constructor */
	public Forumpost(Userinfo userinfo, String postTitle, String postContent,
			Integer praiseNum, Integer forwardNum, Integer commentNum,
			Integer browseNum, Timestamp publishTime, String isLegal,
			Integer collectNum, Set userinfos, Set userinfos_1,
			Set usercomments, Set tags, Set userinfos_2) {
		this.userinfo = userinfo;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.praiseNum = praiseNum;
		this.forwardNum = forwardNum;
		this.commentNum = commentNum;
		this.browseNum = browseNum;
		this.publishTime = publishTime;
		this.isLegal = isLegal;
		this.collectNum = collectNum;
		this.userinfos = userinfos;
		this.userinfos_1 = userinfos_1;
		this.usercomments = usercomments;
		this.tags = tags;
		this.userinfos_2 = userinfos_2;
	}

	// Property accessors

	public Integer getPostId() {
		return this.postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getPostTitle() {
		return this.postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return this.postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Integer getPraiseNum() {
		return this.praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Integer getForwardNum() {
		return this.forwardNum;
	}

	public void setForwardNum(Integer forwardNum) {
		this.forwardNum = forwardNum;
	}

	public Integer getCommentNum() {
		return this.commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
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

	public Set getUsercomments() {
		return this.usercomments;
	}

	public void setUsercomments(Set usercomments) {
		this.usercomments = usercomments;
	}

	public Set getTags() {
		return this.tags;
	}

	public void setTags(Set tags) {
		this.tags = tags;
	}

	public Set getUserinfos_2() {
		return this.userinfos_2;
	}

	public void setUserinfos_2(Set userinfos_2) {
		this.userinfos_2 = userinfos_2;
	}

}