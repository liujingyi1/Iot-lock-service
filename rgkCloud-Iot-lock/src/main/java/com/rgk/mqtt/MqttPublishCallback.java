package com.rgk.mqtt;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttPublishCallback implements MqttCallback {
	private Log log = LogFactory.getLog(getClass());
	
	private IMessageHandler messageHandler = new MessageHandler();

	// 连接丢失，进行重连
	@Override
	public void connectionLost(Throwable cause) {
		log.info("连接断开，可以重新连接"+cause.getMessage());
		MqttClientUtil.getInstance().doClientConnection();
	}

	// 订阅后，收到消息
	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		log.info("主题 ： " + topic);
		log.info("QoS ： " + message.getQos());
		log.info("内容 ： " + new String(message.getPayload()));

		try {
			String[] strArr = topic.split("/");
			String deviceId = strArr[strArr.length-1];
			String messageStr = new String(message.getPayload());
			
			Method method = messageHandler.getClass().getDeclaredMethod(strArr[strArr.length-2], String.class, String.class);
			method.invoke(messageHandler, deviceId, messageStr);
		} catch (Exception e) {
		}
	}

	// 传送完成
	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		log.info("deliveryComplete : "+token.isComplete());
	}

}
