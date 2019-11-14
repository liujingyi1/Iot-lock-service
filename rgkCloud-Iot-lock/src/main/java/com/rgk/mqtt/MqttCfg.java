package com.rgk.mqtt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="spring.mqtt")
public class MqttCfg {
	private String userName;
	
	private String password;
	
	private String host;
	
	private String clientId;
	
	
	private Integer timeout;
	
	private Integer keepalive;



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public Integer getKeepalive() {
		return keepalive;
	}

	public void setKeepalive(Integer keepalive) {
		this.keepalive = keepalive;
	}
	
	
	
	

}
