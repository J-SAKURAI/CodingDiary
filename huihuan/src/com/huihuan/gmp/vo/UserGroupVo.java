package com.huihuan.gmp.vo;

import java.util.List;

public class UserGroupVo {
	private Long id;
	private String name;
	private Long fatherUserGroupId;
	private List children;
	private String text;
	private Integer type;

	/*public UserGroupVo() {
		this.type = 1;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFatherUserGroupId() {
		return fatherUserGroupId;
	}

	public void setFatherUserGroupId(Long fatherUserGroupId) {
		this.fatherUserGroupId = fatherUserGroupId;
	}

	public List getChildren() {
		return children;
	}

	public void setChildren(List children) {
		this.children = children;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
