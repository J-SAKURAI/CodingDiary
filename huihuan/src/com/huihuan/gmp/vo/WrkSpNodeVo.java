package com.huihuan.gmp.vo;

import java.util.List;

public class WrkSpNodeVo {
private List children;
private long id;
private long textid;
public long getTextid() {
	return textid;
}
public void setTextid(long textid) {
	this.textid = textid;
}
private String text;
private int level;
private String name;
private String type;
private int typeid;

public List getChildren() {
	return children;
}
public void setChildren(List children) {
	this.children = children;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getTypeid() {
	return typeid;
}
public void setTypeid(int typeid) {
	this.typeid = typeid;
}

}
