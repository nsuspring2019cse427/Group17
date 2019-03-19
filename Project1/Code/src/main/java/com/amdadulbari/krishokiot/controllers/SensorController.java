package com.amdadulbari.krishokiot.controllers;

import com.amdadulbari.krishokiot.constants.SettingsConstants;
import com.amdadulbari.krishokiot.models.SensorsModel;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

public class SensorController {
    public String setSensorData(String payload) {
        try {
            JsonObject payloadObject = Json.parse(payload).asObject();
            String deviceID = payloadObject.getString("id", "");
            float temp = payloadObject.getFloat("temp", -999.99f);
            float humidity = payloadObject.getFloat("humidity", -999.99f);
            SensorsModel sensorsModel = new SensorsModel();
            sensorsModel.setTemp(temp);
            sensorsModel.setHumidity(humidity);
            sensorsModel.setDeviceID(deviceID);
            // TODO Save It to database
            return SettingsConstants.successJson;
        } catch (Exception e) {
            //e.printStackTrace();
            return SettingsConstants.failedJson;
        }
    }

}
