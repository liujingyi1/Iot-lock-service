package com.rgk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "m_lock_password")
@EntityListeners(AuditingEntityListener.class)
public class MPassword {
    @Id
    @GenericGenerator(name="uuidGenerator",strategy="uuid")
    @GeneratedValue(generator="uuidGenerator")
    @Column(length = 100)
    private String id;
    
    private String passowrd;
    
    private Long startTime;
    
    private Long expireDate;
    
    private Boolean isOTP;
    
    private Integer type;
    
    private String deviceId;
	
	public MPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MPassword(String passowrd, Long startTime, Long expireDate, Boolean isOTP, Integer type) {
		super();
		this.passowrd = passowrd;
		this.startTime = startTime;
		this.expireDate = expireDate;
		this.isOTP = isOTP;
		this.type = type;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Long expireDate) {
		this.expireDate = expireDate;
	}

	public Boolean getIsOTP() {
		return isOTP;
	}

	public void setIsOTP(Boolean isOTP) {
		this.isOTP = isOTP;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
