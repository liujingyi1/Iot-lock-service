package com.rgk.mqtt;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.rgk.SpringContextUtils;
import com.rgk.entity.MDevice;
import com.rgk.repository.IDeviceDao;

public class MessageHandler implements IMessageHandler{

	private IDeviceDao deviceDao = (IDeviceDao)SpringContextUtils.getBeanByClass(IDeviceDao.class);
	
	@Override
	public void uploadAccessLog(String deviceId, String message) {
		System.out.println("uploadAccessLog "+"deviceid="+deviceId+" message="+message);
		
		MDevice device = JSON.parseObject(message, MDevice.class);
		device.setDeviceNo(deviceId);
		
		MDevice orgDevice = deviceDao.findByDeviceNo(deviceId);
		if (orgDevice != null) {
			device.setId(orgDevice.getId());
		}
		
		deviceDao.save(device);
		if (StringUtils.isNotBlank(device.getId())) {
			
		}
	}

	@Override
	public void uploadDoorSensor(String deviceId, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadDeviceInfo(String deviceId, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadDeviceEvent(String deviceId, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadDeviceMaintain(String deviceId, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filterRequest(String deviceId, String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void response(String deviceId, String message) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
