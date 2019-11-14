package com.rgk.mqtt.service;

import com.rgk.entity.MCard;

public interface IMqttService {
	public boolean dispatchOTP(String deviceId, String password, Long startTime, Long expireDate);

	public boolean dispatchCardInfo(String deviceId, MCard card, Long endTime, String filterType);
}
