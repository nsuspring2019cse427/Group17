package com.amdadulbari.krishokiot.controllers;

import com.amdadulbari.krishokiot.constants.SettingsConstants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SensorControllerTest {

    @Test
    public void setSensorDataWhenAllValid() {
        String payload = "{\"temp\":33.2,\"humidity\":44.5}";
        SensorController sensorController = new SensorController();
        assertEquals(SettingsConstants.successJson, sensorController.setSensorData(payload));
    }

    @Test
    public void setSensorDataWhenTempInValid() {
        String payload = "{\"temp\":33.2,\"humidity\":55.32}";
        String payload2 = "{\"temp\":-33.2,\"humidity\":55.32}";
        String payload3 = "{\"temp\":,\"humidity\":55.32}";
        String payload4 = "{\"temp\":\"22\",\"humidity\":55.32}";

        SensorController sensorController = new SensorController();
        assertEquals(SettingsConstants.successJson, sensorController.setSensorData(payload));
        assertEquals(SettingsConstants.successJson, sensorController.setSensorData(payload2));
        assertEquals(SettingsConstants.failedJson, sensorController.setSensorData(payload3));
        assertEquals(SettingsConstants.failedJson, sensorController.setSensorData(payload4));
    }

    @Test
    public void setSensorDataWhenHumidInValid() {
        String payload = "{\"temp\":33.3,\"humidity\":22.8}";
        String payload2 = "{\"temp\":33.3,\"humidity\":-22.8}";
        String payload3 = "{\"temp\":33.3,\"humidity\":\"aaa\"}";
        String payload4 = "{\"temp\":33.3,\"humidity\":\"\"}";

        SensorController sensorController = new SensorController();
        assertEquals(SettingsConstants.successJson, sensorController.setSensorData(payload));
        assertEquals(SettingsConstants.successJson, sensorController.setSensorData(payload2));
        assertEquals(SettingsConstants.failedJson, sensorController.setSensorData(payload3));
        assertEquals(SettingsConstants.failedJson, sensorController.setSensorData(payload4));
    }

    @Test
    public void setSensorDataWhenAllInvalid() {
        String payload1 = "{\"temp\":null,\"humidity\":null}";
        String payload2 = "{\"temp\":\"xx\",\"humidity\":\"aa\"}";
        String payload3 = "{\"temp\":\"\",\"humidity\":\"\"}";

        SensorController sensorController = new SensorController();
        assertEquals(SettingsConstants.failedJson, sensorController.setSensorData(payload1));
        assertEquals(SettingsConstants.failedJson, sensorController.setSensorData(payload2));
        assertEquals(SettingsConstants.failedJson, sensorController.setSensorData(payload3));

    }
}