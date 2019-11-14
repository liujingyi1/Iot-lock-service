package com.rgk.mqtt.bean;

public class CardBean {
	String cardNo;
	
	String seqNo;
	
	Long endTime;
	
	Boolean isBlack;
	
	Boolean isWhite;
	
	String filterType;
	
	public CardBean(String cardNo, String seqNo, Long endTime, String filterType) {
		super();
		this.cardNo = cardNo;
		this.seqNo = seqNo;
		this.endTime = endTime;
		this.filterType = filterType;
	}
	
	public Boolean getIsBlack() {
		return isBlack;
	}

	public void setIsBlack(Boolean isBlack) {
		this.isBlack = isBlack;
	}


	public Boolean getIsWhite() {
		return isWhite;
	}


	public void setIsWhite(Boolean isWhite) {
		this.isWhite = isWhite;
	}


	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public String getFilterType() {
		return filterType;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
	
	
}
