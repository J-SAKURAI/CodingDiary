package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * ProductLinesWorkSteps entity. @author MyEclipse Persistence Tools
 */

public class ProductLinesWorkSteps implements java.io.Serializable {

	// Fields

	private Long id;
	private WorkSteps workSteps;
	private ProductionLines productionLines;
	private Warehouses warehouses;
	private Integer aftRcvAutoInvst;
	private Integer selfPicking;
	private Integer rcvDfct;
	private Integer signIn;
	private Integer clearArea;
	private Integer clearAreaTmSpc;
	private Integer clearAreaTmBtch;
	private Integer btchRvwMod;
	private Integer btchPrdSortOut;
	private Integer wghRcvMtrl;
	private Integer wghPtinMtrl;
	private Integer wghMidPrd;
	private Integer wghTrnOutMtrl;
	private Integer midPrdLbl;
	private Integer rcvRawMtrlLbl;
	private Integer rcvPackMtrlLbl;
	private Integer trnTMidPrdLbl;
	private Integer trnTRcvPrdLbl;
	private Integer putInMtrlLbl;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set operationRoomses = new HashSet(0);

	// Constructors

	/** default constructor */
	public ProductLinesWorkSteps() {
	}

	/** minimal constructor */
	public ProductLinesWorkSteps(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public ProductLinesWorkSteps(WorkSteps workSteps,
			ProductionLines productionLines, Warehouses warehouses,
			Integer aftRcvAutoInvst, Integer selfPicking, Integer rcvDfct,
			Integer signIn, Integer clearArea, Integer clearAreaTmSpc,
			Integer clearAreaTmBtch, Integer btchRvwMod,
			Integer btchPrdSortOut, Integer wghRcvMtrl, Integer wghPtinMtrl,
			Integer wghMidPrd, Integer wghTrnOutMtrl, Integer midPrdLbl,
			Integer rcvRawMtrlLbl, Integer rcvPackMtrlLbl,
			Integer trnTMidPrdLbl, Integer trnTRcvPrdLbl, Integer putInMtrlLbl,
			Integer status, Timestamp crtTm, String crtUsr, Timestamp updTm,
			String updUsr, Set operationRoomses) {
		this.workSteps = workSteps;
		this.productionLines = productionLines;
		this.warehouses = warehouses;
		this.aftRcvAutoInvst = aftRcvAutoInvst;
		this.selfPicking = selfPicking;
		this.rcvDfct = rcvDfct;
		this.signIn = signIn;
		this.clearArea = clearArea;
		this.clearAreaTmSpc = clearAreaTmSpc;
		this.clearAreaTmBtch = clearAreaTmBtch;
		this.btchRvwMod = btchRvwMod;
		this.btchPrdSortOut = btchPrdSortOut;
		this.wghRcvMtrl = wghRcvMtrl;
		this.wghPtinMtrl = wghPtinMtrl;
		this.wghMidPrd = wghMidPrd;
		this.wghTrnOutMtrl = wghTrnOutMtrl;
		this.midPrdLbl = midPrdLbl;
		this.rcvRawMtrlLbl = rcvRawMtrlLbl;
		this.rcvPackMtrlLbl = rcvPackMtrlLbl;
		this.trnTMidPrdLbl = trnTMidPrdLbl;
		this.trnTRcvPrdLbl = trnTRcvPrdLbl;
		this.putInMtrlLbl = putInMtrlLbl;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.operationRoomses = operationRoomses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public WorkSteps getWorkSteps() {
		return this.workSteps;
	}

	public void setWorkSteps(WorkSteps workSteps) {
		this.workSteps = workSteps;
	}

	public ProductionLines getProductionLines() {
		return this.productionLines;
	}

	public void setProductionLines(ProductionLines productionLines) {
		this.productionLines = productionLines;
	}

	public Warehouses getWarehouses() {
		return this.warehouses;
	}

	public void setWarehouses(Warehouses warehouses) {
		this.warehouses = warehouses;
	}

	public Integer getAftRcvAutoInvst() {
		return this.aftRcvAutoInvst;
	}

	public void setAftRcvAutoInvst(Integer aftRcvAutoInvst) {
		this.aftRcvAutoInvst = aftRcvAutoInvst;
	}

	public Integer getSelfPicking() {
		return this.selfPicking;
	}

	public void setSelfPicking(Integer selfPicking) {
		this.selfPicking = selfPicking;
	}

	public Integer getRcvDfct() {
		return this.rcvDfct;
	}

	public void setRcvDfct(Integer rcvDfct) {
		this.rcvDfct = rcvDfct;
	}

	public Integer getSignIn() {
		return this.signIn;
	}

	public void setSignIn(Integer signIn) {
		this.signIn = signIn;
	}

	public Integer getClearArea() {
		return this.clearArea;
	}

	public void setClearArea(Integer clearArea) {
		this.clearArea = clearArea;
	}

	public Integer getClearAreaTmSpc() {
		return this.clearAreaTmSpc;
	}

	public void setClearAreaTmSpc(Integer clearAreaTmSpc) {
		this.clearAreaTmSpc = clearAreaTmSpc;
	}

	public Integer getClearAreaTmBtch() {
		return this.clearAreaTmBtch;
	}

	public void setClearAreaTmBtch(Integer clearAreaTmBtch) {
		this.clearAreaTmBtch = clearAreaTmBtch;
	}

	public Integer getBtchRvwMod() {
		return this.btchRvwMod;
	}

	public void setBtchRvwMod(Integer btchRvwMod) {
		this.btchRvwMod = btchRvwMod;
	}

	public Integer getBtchPrdSortOut() {
		return this.btchPrdSortOut;
	}

	public void setBtchPrdSortOut(Integer btchPrdSortOut) {
		this.btchPrdSortOut = btchPrdSortOut;
	}

	public Integer getWghRcvMtrl() {
		return this.wghRcvMtrl;
	}

	public void setWghRcvMtrl(Integer wghRcvMtrl) {
		this.wghRcvMtrl = wghRcvMtrl;
	}

	public Integer getWghPtinMtrl() {
		return this.wghPtinMtrl;
	}

	public void setWghPtinMtrl(Integer wghPtinMtrl) {
		this.wghPtinMtrl = wghPtinMtrl;
	}

	public Integer getWghMidPrd() {
		return this.wghMidPrd;
	}

	public void setWghMidPrd(Integer wghMidPrd) {
		this.wghMidPrd = wghMidPrd;
	}

	public Integer getWghTrnOutMtrl() {
		return this.wghTrnOutMtrl;
	}

	public void setWghTrnOutMtrl(Integer wghTrnOutMtrl) {
		this.wghTrnOutMtrl = wghTrnOutMtrl;
	}

	public Integer getMidPrdLbl() {
		return this.midPrdLbl;
	}

	public void setMidPrdLbl(Integer midPrdLbl) {
		this.midPrdLbl = midPrdLbl;
	}

	public Integer getRcvRawMtrlLbl() {
		return this.rcvRawMtrlLbl;
	}

	public void setRcvRawMtrlLbl(Integer rcvRawMtrlLbl) {
		this.rcvRawMtrlLbl = rcvRawMtrlLbl;
	}

	public Integer getRcvPackMtrlLbl() {
		return this.rcvPackMtrlLbl;
	}

	public void setRcvPackMtrlLbl(Integer rcvPackMtrlLbl) {
		this.rcvPackMtrlLbl = rcvPackMtrlLbl;
	}

	public Integer getTrnTMidPrdLbl() {
		return this.trnTMidPrdLbl;
	}

	public void setTrnTMidPrdLbl(Integer trnTMidPrdLbl) {
		this.trnTMidPrdLbl = trnTMidPrdLbl;
	}

	public Integer getTrnTRcvPrdLbl() {
		return this.trnTRcvPrdLbl;
	}

	public void setTrnTRcvPrdLbl(Integer trnTRcvPrdLbl) {
		this.trnTRcvPrdLbl = trnTRcvPrdLbl;
	}

	public Integer getPutInMtrlLbl() {
		return this.putInMtrlLbl;
	}

	public void setPutInMtrlLbl(Integer putInMtrlLbl) {
		this.putInMtrlLbl = putInMtrlLbl;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCrtTm() {
		return this.crtTm;
	}

	public void setCrtTm(Timestamp crtTm) {
		this.crtTm = crtTm;
	}

	public String getCrtUsr() {
		return this.crtUsr;
	}

	public void setCrtUsr(String crtUsr) {
		this.crtUsr = crtUsr;
	}

	public Timestamp getUpdTm() {
		return this.updTm;
	}

	public void setUpdTm(Timestamp updTm) {
		this.updTm = updTm;
	}

	public String getUpdUsr() {
		return this.updUsr;
	}

	public void setUpdUsr(String updUsr) {
		this.updUsr = updUsr;
	}

	public Set getOperationRoomses() {
		return this.operationRoomses;
	}

	public void setOperationRoomses(Set operationRoomses) {
		this.operationRoomses = operationRoomses;
	}

}