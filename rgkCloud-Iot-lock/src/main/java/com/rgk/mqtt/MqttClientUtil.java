package com.rgk.mqtt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import com.alibaba.fastjson.JSON;

//@ConfigurationProperties(prefix = "mqtt")
public class MqttClientUtil {
	private Log log = LogFactory.getLog(getClass());
	
//	@Value("${mqtt.userName}")
//	private String userName;
//	@Value("${mqtt.password}")
//	private String password;
//	@Value("${mqtt.host}")
//	private String host;
//	@Value("${mqtt.clientId}")
//	private String clientId;
//	@Value("${mqtt.timeout}")
//	private Integer timeout;
//	@Value("${mqtt.keepalive}")
//	private Integer keepalive;
	
	
	private String userName = "admin";
	private String password = "123456";
	private String host = "tcp://192.168.160.33:61613";
	private String clientId = "jingyi4bf6e1b0906cf";
	
//	private String userName = "shhx";
//	private String password = "7ed98d7018caf009c60008521274ceb4";
//	private String host = "tcp://220.248.34.75:3001";
//	private String clientId = "jingyi4bf6e1b0906cf";
	private Integer timeout = 10;
	private Integer keepalive = 60;

	private MqttClient mqttClient;
	
	private static volatile MqttClientUtil mqttClientUtil = null;

    private String[] SERVER_TOPICS = {
    		MqttTopics.UPLOAD_ACCESS_LOG+"+",
            MqttTopics.UPLOAD_DOOR_SENSOR+"+",
            MqttTopics.UPLOAD_DEVICE_INFO+"+",
            MqttTopics.UPLOAD_DEVICE_EVENT+"+",
            MqttTopics.UPLOAD_DEVICE_MAINTAIN+"+",
            MqttTopics.FILTER_REQUEST+"+",
            MqttTopics.RESPONSE+"+"};

    private int[] SERVER_QOS = {
    		MqttConstants.QOS_QUALITY_2,
    		MqttConstants.QOS_QUALITY_2,
    		MqttConstants.QOS_QUALITY_2,
    		MqttConstants.QOS_QUALITY_2,
    		MqttConstants.QOS_QUALITY_2,
    		MqttConstants.QOS_QUALITY_2,
    		MqttConstants.QOS_QUALITY_2};
    
	public static MqttClientUtil getInstance() {
		if (mqttClientUtil == null) {
			mqttClientUtil = new MqttClientUtil();
		}
		return mqttClientUtil;
	}

	public MqttClientUtil() {
//		connet();
	}
	
	public void doClientConnection() {
        if (mqttClient != null && !mqttClient.isConnected()) {
            try {
            	IMqttToken mqttToken = mqttClient.connectWithResult(getConnectOptions());
    			if (mqttToken.isComplete()) {
    				mqttClient.subscribe(SERVER_TOPICS, SERVER_QOS);
    			}
            } catch (MqttException e) {
            	e.printStackTrace();
            }
        }
    }

	public void connet() {
		try {
			log.info("userName : " + userName + "|clientId : " + clientId);
			mqttClient = new MqttClient(host, clientId, new MemoryPersistence());
			mqttClient.setCallback(new MqttPublishCallback());

			doClientConnection();
			
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	private MqttConnectOptions getConnectOptions() {
		MqttConnectOptions opts = new MqttConnectOptions();
		opts.setCleanSession(false);
		opts.setUserName(userName);
		opts.setPassword(password.toCharArray());
		opts.setConnectionTimeout(timeout);
		opts.setKeepAliveInterval(keepalive);
		opts.setAutomaticReconnect(true);
		opts.setMaxInflight(10);
		
		if (host.startsWith("ssl:")) {
			try {
				opts.setSocketFactory(SSLUtil.getSocketFactory("D:/ssl/ca.crt", "D:/ssl/client.crt", "D:/ssl/client.key", "123456"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return opts;
	}

	/**
	 * 发布
	 * 
	 * @param topic
	 * @param payload
	 * @param qos
	 * @param retained
	 */
	public void publish(String topic, MqttPayload payload, int qos, boolean retained) {
		MqttMessage message = new MqttMessage();
		message.setQos(qos);
		message.setPayload(JSON.toJSONString(payload).getBytes());
		message.setRetained(retained);

		MqttTopic mqttTopic = mqttClient.getTopic(topic);
		try {
			MqttDeliveryToken token = mqttTopic.publish(message);
			token.waitForCompletion();
		} catch (MqttPersistenceException e) {
			e.printStackTrace();
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 订阅
	 * 
	 * @param topic
	 * @param qos
	 */
	public void subscribe(String topic, int qos) {
		try {
			mqttClient.subscribe(topic, qos);
		} catch (MqttException e) {
			e.printStackTrace();
		}
	}

}
