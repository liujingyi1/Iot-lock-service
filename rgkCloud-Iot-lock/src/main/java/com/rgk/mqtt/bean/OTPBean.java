package com.rgk.mqtt.bean;

public class OTPBean {
	
	public OTPBean() {
	}

	public OTPBean(String password, Long startTime, Long expireDate, String isOTP) {
		super();
		this.password = password;
		this.startTime = startTime;
		this.expireDate = expireDate;
		this.isOTP = isOTP;
	}

	String password;
	
	Long startTime;
	 
	Long expireDate;
	
	String isOTP;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getIsOTP() {
		return isOTP;
	}

	public void setIsOTP(String isOTP) {
		this.isOTP = isOTP;
	}
	
	
}
