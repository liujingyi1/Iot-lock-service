package com.rgk.mqtt;

public class MqttPayload {
	
	private Integer type = 0;
	
	private String title = "default";
	
	private String content;
	
	

	public MqttPayload() {
		super();
	}

	public MqttPayload(String content) {
		super();
		this.content = content;
	}

	public MqttPayload(Integer type, String title, String content) {
		super();
		this.type = type;
		this.title = title;
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	

}
