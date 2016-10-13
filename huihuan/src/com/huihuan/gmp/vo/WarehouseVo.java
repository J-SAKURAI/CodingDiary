package com.huihuan.gmp.vo;

import java.sql.Timestamp;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

public class WarehouseVo {
	private Long id;
	private String name;
	private String code;
	private Integer type;
	private Integer ioStockWay;
	private Integer binRfidMng;
	private Integer mtrlRfidMng;
	private Integer lctnWgh;
	private Integer plnBthNumCnt;
	private Integer inventoryType;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Integer storeroomNum;
	private List sendAbled;
	private List receiveAbled;
	private List sendList;
	private List receiveList;
	
	
	public List getSendAbled() {
		return sendAbled;
	}
	public void setSendAbled(List sendAbled) {
		this.sendAbled = sendAbled;
	}
	public List getReceiveAbled() {
		return receiveAbled;
	}
	public void setReceiveAbled(List receiveAbled) {
		this.receiveAbled = receiveAbled;
	}
	public List getSendList() {
		return sendList;
	}
	public void setSendList(List sendList) {
		this.sendList = sendList;
	}
	public List getReceiveList() {
		return receiveList;
	}
	public void setReceiveList(List receiveList) {
		this.receiveList = receiveList;
	}
	public Integer getStoreroomNum() {
		return storeroomNum;
	}
	public void setStoreroomNum(Integer storeroomNum) {
		this.storeroomNum = storeroomNum;
	}
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getIoStockWay() {
		return ioStockWay;
	}
	public void setIoStockWay(Integer ioStockWay) {
		this.ioStockWay = ioStockWay;
	}
	public Integer getBinRfidMng() {
		return binRfidMng;
	}
	public void setBinRfidMng(Integer binRfidMng) {
		this.binRfidMng = binRfidMng;
	}
	public Integer getMtrlRfidMng() {
		return mtrlRfidMng;
	}
	public void setMtrlRfidMng(Integer mtrlRfidMng) {
		this.mtrlRfidMng = mtrlRfidMng;
	}
	public Integer getLctnWgh() {
		return lctnWgh;
	}
	public void setLctnWgh(Integer lctnWgh) {
		this.lctnWgh = lctnWgh;
	}
	public Integer getPlnBthNumCnt() {
		return plnBthNumCnt;
	}
	public void setPlnBthNumCnt(Integer plnBthNumCnt) {
		this.plnBthNumCnt = plnBthNumCnt;
	}
	public Integer getInventoryType() {
		return inventoryType;
	}
	public void setInventoryType(Integer inventoryType) {
		this.inventoryType = inventoryType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getCrtTm() {
		return crtTm;
	}
	public void setCrtTm(Timestamp crtTm) {
		this.crtTm = crtTm;
	}
	public String getCrtUsr() {
		return crtUsr;
	}
	public void setCrtUsr(String crtUsr) {
		this.crtUsr = crtUsr;
	}
	public Timestamp getUpdTm() {
		return updTm;
	}
	public void setUpdTm(Timestamp updTm) {
		this.updTm = updTm;
	}
	public String getUpdUsr() {
		return updUsr;
	}
	public void setUpdUsr(String updUsr) {
		this.updUsr = updUsr;
	}


}
