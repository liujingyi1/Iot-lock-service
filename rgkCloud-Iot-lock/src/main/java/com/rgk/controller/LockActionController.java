package com.rgk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgk.mqtt.service.IMqttService;
import com.rgk.pojo.ReturnObject;
import com.rgk.service.IMemberService;
import com.rgk.service.IPasswordService;

@RestController
@RequestMapping("/lockaction")
public class LockActionController {
	
	@Autowired
	IMqttService mqttService;
	
	@Autowired
	IMemberService memberService;
	
	@Autowired
	IPasswordService passwordService;
	
	
	@RequestMapping("/getOTP")
	public ReturnObject getTempPassword(String phone, String deviceId, Long startTime, Long endTime) {
		
		ReturnObject ret = passwordService.createOTP(deviceId, startTime, endTime);
		
		if (ret.getCode() == 1) {
			mqttService.dispatchOTP(deviceId, ret.getResult().toString(), startTime, endTime);
		}
			
		return ret;
	}
	
	@RequestMapping("/getDeviceInfo")
	public ReturnObject getDeviceInfo(String phone) {
		
		return memberService.findAllRoomsByPhone(phone);
		
	}
}
