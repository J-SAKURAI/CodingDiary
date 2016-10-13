package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Document entity. @author MyEclipse Persistence Tools
 */

public class Document implements java.io.Serializable {

	// Fields

	private Integer docId;
	private Userinfo userinfo;
	private String docName;
	private Integer praiseNum;
	private Integer commentNum;
	private Timestamp uploadTime;
	private Integer downloadCount;
	private Integer forwardNum;
	private String isLegal;
	private Integer collectNum;
	private Set userinfos = new HashSet(0);
	private Set tags = new HashSet(0);
	private Set userinfos_1 = new HashSet(0);
	private Set userinfos_2 = new HashSet(0);
	private Set usercomments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Document() {
	}

	/** minimal constructor */
	public Document(String docName) {
		this.docName = docName;
	}

	/** full constructor */
	public Document(Userinfo userinfo, String docName, Integer praiseNum,
			Integer commentNum, Timestamp uploadTime, Integer downloadCount,
			Integer forwardNum, String isLegal, Integer collectNum,
			Set userinfos, Set tags, Set userinfos_1, Set userinfos_2,
			Set usercomments) {
		this.userinfo = userinfo;
		this.docName = docName;
		this.praiseNum = praiseNum;
		this.commentNum = commentNum;
		this.uploadTime = uploadTime;
		this.downloadCount = downloadCount;
		this.forwardNum = forwardNum;
		this.isLegal = isLegal;
		this.collectNum = collectNum;
		this.userinfos = userinfos;
		this.tags = tags;
		this.userinfos_1 = userinfos_1;
		this.userinfos_2 = userinfos_2;
		this.usercomments = usercomments;
	}

	// Property accessors

	public Integer getDocId() {
		return this.docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getDocName() {
		return this.docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
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

	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Integer getDownloadCount() {
		return this.downloadCount;
	}

	public void setDownloadCount(Integer downloadCount) {
		this.downloadCount = downloadCount;
	}

	public Integer getForwardNum() {
		return this.forwardNum;
	}

	public void setForwardNum(Integer forwardNum) {
		this.forwardNum = forwardNum;
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

	public Set getTags() {
		return this.tags;
	}

	public void setTags(Set tags) {
		this.tags = tags;
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