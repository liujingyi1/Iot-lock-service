package com.rgk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgk.entity.MPassword;
import com.rgk.pojo.ReturnObject;
import com.rgk.repository.IDeviceDao;
import com.rgk.repository.IPasswordDao;
import com.rgk.service.IPasswordService;

@Service
public class PasswordServiceImpl implements IPasswordService {

	@Autowired
	IPasswordDao passwordDao;
	
	@Autowired
	IDeviceDao deviceDao;
	
	
	@Override
	public ReturnObject createOTP(String deviceId, Long startTime, Long endTime) {

		
		String randomPwd = String.format("%06d", (int)((Math.random()*9+1)*100000));
		
		List<MPassword> passwords = passwordDao.findByPassowrdAndIsOTPAndType(randomPwd, true, 0);
			
	    while (passwords != null && passwords.size() > 0) {
	    	randomPwd = String.format("%06d", (int)((Math.random()*9+1)*100000));
	    	passwords = passwordDao.findByPassowrd(randomPwd);
		}
	    
	    MPassword password = new MPassword(randomPwd, startTime, endTime, true, 0);
	    passwordDao.save(password);
//	    if (StringUtils.isNotBlank(password.getId())) {
//		    MDevice device = deviceDao.findByDeviceId(deviceId);
//		    device.getPasswords().add(password);
//		    deviceDao.save(device);
//	    } else {
//	    	return new ReturnObject(-1, null, "fail");
//	    }
		
		return new ReturnObject(1, password.getPassowrd(), null);
	}

	
}
