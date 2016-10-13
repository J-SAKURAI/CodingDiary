package com.huihuan.gmp.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EasyTreeNode {
	public String id;
	public String text;
	public String iconCls;
	public String state;
	public String tag;
	public String level;
	public List<EasyTreeNode> children;
	public Map attributes;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<EasyTreeNode> getChildren() {
		return children;
	}

	public void setChildren(List<EasyTreeNode> children) {
		this.children = children;
	}

	public Map getAttributes() {
		return attributes;
	}

	public void setAttributes(Map attributes) {
		this.attributes = attributes;
	}


	public EasyTreeNode() {
		this.children = new ArrayList<EasyTreeNode> ();
		this.attributes = new HashMap();
	}
	public EasyTreeNode(String id, String text, String iconCls, String state,
			String tag, String level, ArrayList<EasyTreeNode> children,
			Map attributes) {
		this.id = id;
		this.text = text;
		this.iconCls = iconCls;
		this.state = state;
		this.tag = tag;
		this.level = level;
		this.children = children;
		this.attributes = attributes;
	}

	public EasyTreeNode(String id, String text, String iconCls, String state,
			String tag, String level) {
		this.id = id;
		this.text = text;
		this.iconCls = iconCls;
		this.state = state;
		this.tag = tag;
		this.level = level;
		this.children = new ArrayList<EasyTreeNode> ();
		this.attributes = new HashMap();
	}
}
