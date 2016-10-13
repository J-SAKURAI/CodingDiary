package com.huihuan.gmp.vo;

import java.util.List;

public class TreeMenuVo {
	private String text;
	private String href;
	private List<TreeMenuVo> nodes;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public List<TreeMenuVo> getNodes() {
		return nodes;
	}
	public void setNodes(List<TreeMenuVo> nodes) {
		this.nodes = nodes;
	}
	
}
