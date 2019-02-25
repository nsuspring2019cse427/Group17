package com.amdadulbari.krishokiot.controllers;

import com.amdadulbari.krishokiot.constants.SettingsConstants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SensorControllerTest {

    @Test
    public void setSensorData() {
        String payload = "{\"temp\":33.2,\"humidity\":70}";
        SensorController sensorController = new SensorController();
        assertEquals(SettingsConstants.successJson, sensorController.setSensorData(payload));
    }
}