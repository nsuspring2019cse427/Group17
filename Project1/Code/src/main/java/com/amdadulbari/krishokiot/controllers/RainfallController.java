package com.amdadulbari.krishokiot.controllers;

import com.amdadulbari.krishokiot.constants.SettingsConstants;
import com.amdadulbari.krishokiot.daos.RainfallDao;
import com.amdadulbari.krishokiot.models.RainfallModel;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

public class RainfallController {
    RainfallDao rainfallDao = new RainfallDao();

    public String save(String payload) {
        try {
            JsonObject payloadObject = Json.parse(payload).asObject();
            int landId = payloadObject.getInt("landId", 0);
            float rainfallMM = payloadObject.getFloat("rainfallMM", 0.0f);
            RainfallModel rainfallModel = new RainfallModel();
            rainfallModel.setLandId(landId);
            rainfallModel.setRainfallMM(rainfallMM);
            rainfallDao.save(rainfallModel);
            return SettingsConstants.successJson;
        } catch (Exception e) {
            return SettingsConstants.failedJson;
        }
    }
}
