package com.amdadulbari.krishokiot.controllers;

import com.amdadulbari.krishokiot.constants.SettingsConstants;
import org.junit.Test;

import static org.junit.Assert.*;

public class SensorControllerTest {


    @Test
    public void setSensorData() {
        String payload = "{\"temp\":33.2,\"humidity\":90}";
        SensorController sensorController = new SensorController();
        assertEquals(SettingsConstants.successJson,sensorController.setSensorData(payload));
    }
}