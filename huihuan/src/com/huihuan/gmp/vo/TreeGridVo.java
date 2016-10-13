package com.huihuan.gmp.vo;

public class TreeGridVo {
	private String id;
	private String name;
	private String _parentId;
	private String state;
	private String type;
	private String url;
	private String icon;
	private String ordr;
	private String is_open2user;
	private String is_open;
	private String is_open2alluser;
	
	public String getOrdr() {
		return ordr;
	}
	public void setOrdr(String ordr) {
		this.ordr = ordr;
	}
	public String getIs_open2user() {
		return is_open2user;
	}
	public void setIs_open2user(String is_open2user) {
		this.is_open2user = is_open2user;
	}
	public String getIs_open() {
		return is_open;
	}
	public void setIs_open(String is_open) {
		this.is_open = is_open;
	}
	public String getIs_open2alluser() {
		return is_open2alluser;
	}
	public void setIs_open2alluser(String is_open2alluser) {
		this.is_open2alluser = is_open2alluser;
	}
	private String iconCls;


	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String get_parentId() {
		return _parentId;
	}
	public void set_parentId(String _parentId) {
		this._parentId = _parentId;
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
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
