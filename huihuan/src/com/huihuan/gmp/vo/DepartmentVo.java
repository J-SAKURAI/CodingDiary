package com.huihuan.gmp.vo;

import java.util.List;

public class DepartmentVo {
	private Long id;
	private String code;
	private String name;
	private Long fatherDepartmentId;
	private List children;
	private String text;
	private Integer type;

	/*public DepartmentVo() {
		this.type = 0;
	}*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFatherDepartmentId() {
		return fatherDepartmentId;
	}

	public void setFatherDepartmentId(Long fatherDepartmentId) {
		this.fatherDepartmentId = fatherDepartmentId;
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
