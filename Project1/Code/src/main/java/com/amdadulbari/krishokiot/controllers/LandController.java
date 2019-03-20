package com.amdadulbari.krishokiot.controllers;

import com.amdadulbari.krishokiot.daos.LandDao;
import com.amdadulbari.krishokiot.models.LandModel;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

public class LandController {
    LandDao landDao = new LandDao();

    public boolean saveLand(String payload) {
        try {
            JsonObject payloadObject = Json.parse(payload).asObject();
            String landType = payloadObject.getString("landType", "");
            double sqft = payloadObject.getDouble("sqft", 0.0);
            double lat = payloadObject.getDouble("lat", 0.0);
            double lon = payloadObject.getDouble("lon", 0.0);
            if (sqft < 0 || !landType.trim().equals("")) {
                return false;
            }

            LandModel landModel = new LandModel();
            landModel.setLandType(landType);
            landModel.setSqft(sqft);
            landModel.setLat(lat);
            landModel.setLon(lon);
            landDao.save(landModel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getPreferedCropType(double sqft, double lat, double lon) {

        return "jute";
    }

}
