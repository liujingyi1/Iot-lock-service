package com.rgk.mqtt;

public interface IMessageHandler {
    void uploadAccessLog(String deviceId, String message);
    void uploadDoorSensor(String deviceId, String message);
    void uploadDeviceInfo(String deviceId, String message);
    void uploadDeviceEvent(String deviceId, String message);
    void uploadDeviceMaintain(String deviceId, String message);
    void filterRequest(String deviceId, String message);
    void response(String deviceId, String message);
}
