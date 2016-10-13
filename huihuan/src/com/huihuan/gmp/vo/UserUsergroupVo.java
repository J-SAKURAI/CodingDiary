package com.huihuan.gmp.vo;

public class UserUsergroupVo {
	private long user_id;
	
	private String user_name;
	private String usergroup_name;
	private long type;
	public long getType() {
		return type;
	}
	public void setType(long type) {
		this.type = type;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String  getUsergroup_name() {
		return usergroup_name;
	}
	public void setUsergroup_name(String  usergroup_name) {
		this.usergroup_name = usergroup_name;
	}
}
