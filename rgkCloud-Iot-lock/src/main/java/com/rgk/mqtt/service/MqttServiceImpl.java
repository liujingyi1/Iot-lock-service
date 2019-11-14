package com.rgk.mqtt.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rgk.entity.MCard;
import com.rgk.mqtt.MqttClientUtil;
import com.rgk.mqtt.MqttConstants;
import com.rgk.mqtt.MqttPayload;
import com.rgk.mqtt.MqttTopics;
import com.rgk.mqtt.bean.CardBean;
import com.rgk.mqtt.bean.OTPBean;

@Service
public class MqttServiceImpl implements IMqttService {

	@Override
	public boolean dispatchOTP(String deviceId, String password, Long startTime, Long expireDate) {
		
		OTPBean otpBean = new OTPBean(password, startTime, expireDate, "0");
		
		MqttPayload payload = new MqttPayload(JSON.toJSONString(otpBean));
		
		MqttClientUtil.getInstance().publish(MqttTopics.DISPATCH_OTP+deviceId, payload,
				MqttConstants.QOS_QUALITY_0, MqttConstants.RETAINED_DISABLE);
		
		return true;
	}

	@Override
	public boolean dispatchCardInfo(String deviceId, MCard card, Long endTime, String filterType) {
		
		CardBean cardBean = new CardBean(card.getCardNumber(), "0", endTime, filterType);
		cardBean.setIsBlack(card.getIsBlack());
		cardBean.setIsWhite(card.getIsWhite());
		
		MqttPayload payload = new MqttPayload(JSON.toJSONString(cardBean));
		MqttClientUtil.getInstance().publish(MqttTopics.DISPATCH_OTP+deviceId, payload,
				MqttConstants.QOS_QUALITY_0, MqttConstants.RETAINED_DISABLE);
		
		return false;
	}
	
	
}
