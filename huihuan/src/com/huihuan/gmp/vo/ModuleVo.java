package com.huihuan.gmp.vo;

import java.util.List;

public class ModuleVo {
	private String id;
	private String name;
	private String parent;
	private String type;
	private String url;
	private String ordr;
	private String icon;
	private String isOpen2user;
	private String isOpen;
	private String isOpen2alluser;
	private Long fatherModuleId;
	private List<ModuleVo> children;
	private String text;
	private String state;
	private String attributes;

	public Long getFatherModuleId() {
		return fatherModuleId;
	}

	public void setFatherModuleId(Long fatherModuleId) {
		this.fatherModuleId = fatherModuleId;
	}

	public String getOrdr() {
		return ordr;
	}

	public void setOrdr(String ordr) {
		this.ordr = ordr;
	}

	public String getIsOpen2user() {
		return isOpen2user;
	}

	public void setIsOpen2user(String isOpen2user) {
		this.isOpen2user = isOpen2user;
	}

	public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public String getIsOpen2alluser() {
		return isOpen2alluser;
	}

	public void setIsOpen2alluser(String isOpen2alluser) {
		this.isOpen2alluser = isOpen2alluser;
	}

	public List<ModuleVo> getChildren() {
		return children;
	}

	public void setChildren(List<ModuleVo> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}
