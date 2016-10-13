package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * WorkSteps entity. @author MyEclipse Persistence Tools
 */

public class WorkSteps implements java.io.Serializable {

	// Fields

	private Long id;
	private Crafts crafts;
	private String name;
	private String productName;
	private Integer type;
	private Integer batchDate;
	private Integer SRawMaterial;
	private Integer SPackingMaterial;
	private Integer SMidProduct;
	private Integer SLastEnd;
	private Integer SLesastOneMidProduct;
	private Integer SLeastOneCondition;
	private Integer SNumEnd;
	private Integer ERawMaterial;
	private Integer EPackingMaterial;
	private Integer EMidProduct;
	private Integer ELastEnd;
	private Integer status;
	private Timestamp crtTm;
	private String crtUsr;
	private Timestamp updTm;
	private String updUsr;
	private Set productLinesWorkStepses = new HashSet(0);

	// Constructors

	/** default constructor */
	public WorkSteps() {
	}

	/** minimal constructor */
	public WorkSteps(Timestamp crtTm, Timestamp updTm) {
		this.crtTm = crtTm;
		this.updTm = updTm;
	}

	/** full constructor */
	public WorkSteps(Crafts crafts, String name, String productName,
			Integer type, Integer batchDate, Integer SRawMaterial,
			Integer SPackingMaterial, Integer SMidProduct, Integer SLastEnd,
			Integer SLesastOneMidProduct, Integer SLeastOneCondition,
			Integer SNumEnd, Integer ERawMaterial, Integer EPackingMaterial,
			Integer EMidProduct, Integer ELastEnd, Integer status,
			Timestamp crtTm, String crtUsr, Timestamp updTm, String updUsr,
			Set productLinesWorkStepses) {
		this.crafts = crafts;
		this.name = name;
		this.productName = productName;
		this.type = type;
		this.batchDate = batchDate;
		this.SRawMaterial = SRawMaterial;
		this.SPackingMaterial = SPackingMaterial;
		this.SMidProduct = SMidProduct;
		this.SLastEnd = SLastEnd;
		this.SLesastOneMidProduct = SLesastOneMidProduct;
		this.SLeastOneCondition = SLeastOneCondition;
		this.SNumEnd = SNumEnd;
		this.ERawMaterial = ERawMaterial;
		this.EPackingMaterial = EPackingMaterial;
		this.EMidProduct = EMidProduct;
		this.ELastEnd = ELastEnd;
		this.status = status;
		this.crtTm = crtTm;
		this.crtUsr = crtUsr;
		this.updTm = updTm;
		this.updUsr = updUsr;
		this.productLinesWorkStepses = productLinesWorkStepses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Crafts getCrafts() {
		return this.crafts;
	}

	public void setCrafts(Crafts crafts) {
		this.crafts = crafts;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getBatchDate() {
		return this.batchDate;
	}

	public void setBatchDate(Integer batchDate) {
		this.batchDate = batchDate;
	}

	public Integer getSRawMaterial() {
		return this.SRawMaterial;
	}

	public void setSRawMaterial(Integer SRawMaterial) {
		this.SRawMaterial = SRawMaterial;
	}

	public Integer getSPackingMaterial() {
		return this.SPackingMaterial;
	}

	public void setSPackingMaterial(Integer SPackingMaterial) {
		this.SPackingMaterial = SPackingMaterial;
	}

	public Integer getSMidProduct() {
		return this.SMidProduct;
	}

	public void setSMidProduct(Integer SMidProduct) {
		this.SMidProduct = SMidProduct;
	}

	public Integer getSLastEnd() {
		return this.SLastEnd;
	}

	public void setSLastEnd(Integer SLastEnd) {
		this.SLastEnd = SLastEnd;
	}

	public Integer getSLesastOneMidProduct() {
		return this.SLesastOneMidProduct;
	}

	public void setSLesastOneMidProduct(Integer SLesastOneMidProduct) {
		this.SLesastOneMidProduct = SLesastOneMidProduct;
	}

	public Integer getSLeastOneCondition() {
		return this.SLeastOneCondition;
	}

	public void setSLeastOneCondition(Integer SLeastOneCondition) {
		this.SLeastOneCondition = SLeastOneCondition;
	}

	public Integer getSNumEnd() {
		return this.SNumEnd;
	}

	public void setSNumEnd(Integer SNumEnd) {
		this.SNumEnd = SNumEnd;
	}

	public Integer getERawMaterial() {
		return this.ERawMaterial;
	}

	public void setERawMaterial(Integer ERawMaterial) {
		this.ERawMaterial = ERawMaterial;
	}

	public Integer getEPackingMaterial() {
		return this.EPackingMaterial;
	}

	public void setEPackingMaterial(Integer EPackingMaterial) {
		this.EPackingMaterial = EPackingMaterial;
	}

	public Integer getEMidProduct() {
		return this.EMidProduct;
	}

	public void setEMidProduct(Integer EMidProduct) {
		this.EMidProduct = EMidProduct;
	}

	public Integer getELastEnd() {
		return this.ELastEnd;
	}

	public void setELastEnd(Integer ELastEnd) {
		this.ELastEnd = ELastEnd;
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

	public Set getProductLinesWorkStepses() {
		return this.productLinesWorkStepses;
	}

	public void setProductLinesWorkStepses(Set productLinesWorkStepses) {
		this.productLinesWorkStepses = productLinesWorkStepses;
	}

}