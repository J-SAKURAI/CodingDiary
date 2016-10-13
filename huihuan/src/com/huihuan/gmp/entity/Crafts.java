package com.huihuan.gmp.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Crafts entity. @author MyEclipse Persistence Tools
 */

public class Crafts  implements java.io.Serializable {


    // Fields    

     private Long id;
     private String name;
     private Integer specialType;
     private Integer status;
     private Timestamp crtTm;
     private String crtUsr;
     private Timestamp updTm;
     private String updUsr;
     private Set workStepses = new HashSet(0);
     private Set productionLineses = new HashSet(0);


    // Constructors

    /** default constructor */
    public Crafts() {
    }

	/** minimal constructor */
    public Crafts(Timestamp crtTm, Timestamp updTm) {
        this.crtTm = crtTm;
        this.updTm = updTm;
    }
    
    /** full constructor */
    public Crafts(String name, Integer specialType, Integer status, Timestamp crtTm, String crtUsr, Timestamp updTm, String updUsr, Set workStepses, Set productionLineses) {
        this.name = name;
        this.specialType = specialType;
        this.status = status;
        this.crtTm = crtTm;
        this.crtUsr = crtUsr;
        this.updTm = updTm;
        this.updUsr = updUsr;
        this.workStepses = workStepses;
        this.productionLineses = productionLineses;
    }

   
    // Property accessors

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpecialType() {
        return this.specialType;
    }
    
    public void setSpecialType(Integer specialType) {
        this.specialType = specialType;
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

    public Set getWorkStepses() {
        return this.workStepses;
    }
    
    public void setWorkStepses(Set workStepses) {
        this.workStepses = workStepses;
    }

    public Set getProductionLineses() {
        return this.productionLineses;
    }
    
    public void setProductionLineses(Set productionLineses) {
        this.productionLineses = productionLineses;
    }
   








}