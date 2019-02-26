package com.amdadulbari.krishokiot.models;

import org.springframework.stereotype.Repository;

@Repository
public class SensorsModel {
    private String deviceID;
    private float temp;
    private float humidity;

    public SensorsModel() {
    }

    public SensorsModel(String deviceID, float temp, float humidity) {
        this.deviceID = deviceID;
        this.temp = temp;
        this.humidity = humidity;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "SensorsModel{" +
                "deviceID='" + deviceID + '\'' +
                ", temp=" + temp +
                ", humidity=" + humidity +
                '}';
    }
}
