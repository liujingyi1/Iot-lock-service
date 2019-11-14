package com.rgk.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Table(name = "m_supplier")
@EntityListeners(AuditingEntityListener.class)
public class MSupplier implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GenericGenerator(name="uuidGenerator",strategy="uuid")
    @GeneratedValue(generator="uuidGenerator")
    private String id;
	
	//功能名称
	@Column(name = "function", length = 100)
	private String function;
	
	//供应商名称
	@Column(name = "supplier", length = 100)
	private String supplier;
	
	//启用状态  0：停用   1：启用
	@Column(name = "state", length = 2)
	private Integer State = 0;
	
	@CreatedDate
	public Date createdDate;

	@LastModifiedDate
	public Date modifiedDate;
	
	@LastModifiedBy
	public String modifiedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Integer getState() {
		return State;
	}

	public void setState(Integer state) {
		State = state;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	

}
