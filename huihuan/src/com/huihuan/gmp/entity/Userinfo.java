package com.huihuan.gmp.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String accountNumber;
	private String userPassword;
	private Integer userLevel;
	private Integer xp;
	private String sex;
	private String headPortraint;
	private String nickName;
	private String realName;
	private String teleNum;
	private Date entranceYear;
	private Integer entranceMonth;
	private Date estimateGraduateDateYear;
	private Integer estimateGraduateMonth;
	private String instituteName;
	private String universityName;
	private String isLogIn;
	private String isAdmin;
	private Integer unReadMessageCount;
	private String isGotBlocked;
	private Set blogs = new HashSet(0);
	private Set documents = new HashSet(0);
	private Set forumposts = new HashSet(0);
	private Set forumposts_1 = new HashSet(0);
	private Set blogs_1 = new HashSet(0);
	private Set blogs_2 = new HashSet(0);
	private Set usercomments = new HashSet(0);
	private Set documents_1 = new HashSet(0);
	private Set userinfosForUserId = new HashSet(0);
	private Set documents_2 = new HashSet(0);
	private Set userinfosForFanId = new HashSet(0);
	private Set documents_3 = new HashSet(0);
	private Set forumposts_2 = new HashSet(0);
	private Set blogs_3 = new HashSet(0);
	private Set usercomments_1 = new HashSet(0);
	private Set forumposts_3 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(String accountNumber, String userPassword) {
		this.accountNumber = accountNumber;
		this.userPassword = userPassword;
	}

	/** full constructor */
	public Userinfo(String accountNumber, String userPassword,
			Integer userLevel, Integer xp, String sex, String headPortraint,
			String nickName, String realName, String teleNum,
			Date entranceYear, Integer entranceMonth,
			Date estimateGraduateDateYear, Integer estimateGraduateMonth,
			String instituteName, String universityName, String isLogIn,
			String isAdmin, Integer unReadMessageCount, String isGotBlocked,
			Set blogs, Set documents, Set forumposts, Set forumposts_1,
			Set blogs_1, Set blogs_2, Set usercomments, Set documents_1,
			Set userinfosForUserId, Set documents_2, Set userinfosForFanId,
			Set documents_3, Set forumposts_2, Set blogs_3, Set usercomments_1,
			Set forumposts_3) {
		this.accountNumber = accountNumber;
		this.userPassword = userPassword;
		this.userLevel = userLevel;
		this.xp = xp;
		this.sex = sex;
		this.headPortraint = headPortraint;
		this.nickName = nickName;
		this.realName = realName;
		this.teleNum = teleNum;
		this.entranceYear = entranceYear;
		this.entranceMonth = entranceMonth;
		this.estimateGraduateDateYear = estimateGraduateDateYear;
		this.estimateGraduateMonth = estimateGraduateMonth;
		this.instituteName = instituteName;
		this.universityName = universityName;
		this.isLogIn = isLogIn;
		this.isAdmin = isAdmin;
		this.unReadMessageCount = unReadMessageCount;
		this.isGotBlocked = isGotBlocked;
		this.blogs = blogs;
		this.documents = documents;
		this.forumposts = forumposts;
		this.forumposts_1 = forumposts_1;
		this.blogs_1 = blogs_1;
		this.blogs_2 = blogs_2;
		this.usercomments = usercomments;
		this.documents_1 = documents_1;
		this.userinfosForUserId = userinfosForUserId;
		this.documents_2 = documents_2;
		this.userinfosForFanId = userinfosForFanId;
		this.documents_3 = documents_3;
		this.forumposts_2 = forumposts_2;
		this.blogs_3 = blogs_3;
		this.usercomments_1 = usercomments_1;
		this.forumposts_3 = forumposts_3;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getXp() {
		return this.xp;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeadPortraint() {
		return this.headPortraint;
	}

	public void setHeadPortraint(String headPortraint) {
		this.headPortraint = headPortraint;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getTeleNum() {
		return this.teleNum;
	}

	public void setTeleNum(String teleNum) {
		this.teleNum = teleNum;
	}

	public Date getEntranceYear() {
		return this.entranceYear;
	}

	public void setEntranceYear(Date entranceYear) {
		this.entranceYear = entranceYear;
	}

	public Integer getEntranceMonth() {
		return this.entranceMonth;
	}

	public void setEntranceMonth(Integer entranceMonth) {
		this.entranceMonth = entranceMonth;
	}

	public Date getEstimateGraduateDateYear() {
		return this.estimateGraduateDateYear;
	}

	public void setEstimateGraduateDateYear(Date estimateGraduateDateYear) {
		this.estimateGraduateDateYear = estimateGraduateDateYear;
	}

	public Integer getEstimateGraduateMonth() {
		return this.estimateGraduateMonth;
	}

	public void setEstimateGraduateMonth(Integer estimateGraduateMonth) {
		this.estimateGraduateMonth = estimateGraduateMonth;
	}

	public String getInstituteName() {
		return this.instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public String getUniversityName() {
		return this.universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getIsLogIn() {
		return this.isLogIn;
	}

	public void setIsLogIn(String isLogIn) {
		this.isLogIn = isLogIn;
	}

	public String getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Integer getUnReadMessageCount() {
		return this.unReadMessageCount;
	}

	public void setUnReadMessageCount(Integer unReadMessageCount) {
		this.unReadMessageCount = unReadMessageCount;
	}

	public String getIsGotBlocked() {
		return this.isGotBlocked;
	}

	public void setIsGotBlocked(String isGotBlocked) {
		this.isGotBlocked = isGotBlocked;
	}

	public Set getBlogs() {
		return this.blogs;
	}

	public void setBlogs(Set blogs) {
		this.blogs = blogs;
	}

	public Set getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set documents) {
		this.documents = documents;
	}

	public Set getForumposts() {
		return this.forumposts;
	}

	public void setForumposts(Set forumposts) {
		this.forumposts = forumposts;
	}

	public Set getForumposts_1() {
		return this.forumposts_1;
	}

	public void setForumposts_1(Set forumposts_1) {
		this.forumposts_1 = forumposts_1;
	}

	public Set getBlogs_1() {
		return this.blogs_1;
	}

	public void setBlogs_1(Set blogs_1) {
		this.blogs_1 = blogs_1;
	}

	public Set getBlogs_2() {
		return this.blogs_2;
	}

	public void setBlogs_2(Set blogs_2) {
		this.blogs_2 = blogs_2;
	}

	public Set getUsercomments() {
		return this.usercomments;
	}

	public void setUsercomments(Set usercomments) {
		this.usercomments = usercomments;
	}

	public Set getDocuments_1() {
		return this.documents_1;
	}

	public void setDocuments_1(Set documents_1) {
		this.documents_1 = documents_1;
	}

	public Set getUserinfosForUserId() {
		return this.userinfosForUserId;
	}

	public void setUserinfosForUserId(Set userinfosForUserId) {
		this.userinfosForUserId = userinfosForUserId;
	}

	public Set getDocuments_2() {
		return this.documents_2;
	}

	public void setDocuments_2(Set documents_2) {
		this.documents_2 = documents_2;
	}

	public Set getUserinfosForFanId() {
		return this.userinfosForFanId;
	}

	public void setUserinfosForFanId(Set userinfosForFanId) {
		this.userinfosForFanId = userinfosForFanId;
	}

	public Set getDocuments_3() {
		return this.documents_3;
	}

	public void setDocuments_3(Set documents_3) {
		this.documents_3 = documents_3;
	}

	public Set getForumposts_2() {
		return this.forumposts_2;
	}

	public void setForumposts_2(Set forumposts_2) {
		this.forumposts_2 = forumposts_2;
	}

	public Set getBlogs_3() {
		return this.blogs_3;
	}

	public void setBlogs_3(Set blogs_3) {
		this.blogs_3 = blogs_3;
	}

	public Set getUsercomments_1() {
		return this.usercomments_1;
	}

	public void setUsercomments_1(Set usercomments_1) {
		this.usercomments_1 = usercomments_1;
	}

	public Set getForumposts_3() {
		return this.forumposts_3;
	}

	public void setForumposts_3(Set forumposts_3) {
		this.forumposts_3 = forumposts_3;
	}

}