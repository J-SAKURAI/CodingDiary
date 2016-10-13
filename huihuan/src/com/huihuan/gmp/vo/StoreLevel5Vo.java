package com.huihuan.gmp.vo;

import java.sql.Timestamp;

import com.huihuan.gmp.entity.StoreLevel4;
import com.huihuan.gmp.entity.StoreLevel5;

public class StoreLevel5Vo {
	// Fields

		private Long id;
		private Long storeLevel4Id;
		private String name;
		private String number;
		private Integer status;
		private Timestamp crtTm;
		private String crtUsr;
		private Timestamp updTm;
		private String updUsr;
		private String cusNumber;

		// Constructors

		/** default constructor */
		public StoreLevel5Vo() {
		}

		/** minimal constructor */
		public StoreLevel5Vo(Timestamp crtTm, Timestamp updTm) {
			this.crtTm = crtTm;
			this.updTm = updTm;
		}

		/** full constructor */
		public StoreLevel5Vo(Long storeLevel4Id, String name, String number,
				Integer status, Timestamp crtTm, String crtUsr, Timestamp updTm,
				String updUsr,String cusNumber) {
			this.storeLevel4Id = storeLevel4Id;
			this.name = name;
			this.number = number;
			this.status = status;
			this.crtTm = crtTm;
			this.crtUsr = crtUsr;
			this.updTm = updTm;
			this.updUsr = updUsr;
			this.cusNumber = cusNumber;;
		}

		
		public StoreLevel5Vo(StoreLevel5 S5) {
			this.id=S5.getId();
			this.storeLevel4Id = S5.getStoreLevel4().getId();
			this.name = S5.getName();
			this.number = S5.getNumber();
			this.status = S5.getStatus();
			this.crtTm = S5.getCrtTm();
			this.crtUsr = S5.getCrtUsr();
			this.updTm = S5.getUpdTm();
			this.updUsr = S5.getUpdUsr();
			this.cusNumber = S5.getCusNumber();
		}
		// Property accessors

		public Long getId() {
			return this.id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getStoreLevel4Id() {
			return this.storeLevel4Id;
		}

		public void setStoreLevel4Id(Long storeLevel4Id) {
			this.storeLevel4Id = storeLevel4Id;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNumber() {
			return this.number;
		}

		public void setNumber(String number) {
			this.number = number;
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
		
		public String getCusNumber() {
			return cusNumber;
		}

		public void setCusNumber(String cusNumber) {
			this.cusNumber = cusNumber;
		}

	}