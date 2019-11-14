package com.rgk;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.rgk.mqtt.MqttClientUtil;

@Component
public class LockApplicationRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("LockApplicationRunner class will be execute when the project was started!");
		
//		MqttClientUtil.getInstance().connet();

	}

}
