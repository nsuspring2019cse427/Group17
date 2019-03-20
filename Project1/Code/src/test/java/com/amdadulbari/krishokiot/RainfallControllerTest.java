package com.amdadulbari.krishokiot;

import com.amdadulbari.krishokiot.constants.SettingsConstants;
import com.amdadulbari.krishokiot.controllers.RainfallController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RainfallControllerTest {
    RainfallController rainfallController = new RainfallController();

    @Test
    public void saveWhenAllValid() {
        String payload = "{\"landId\":2,\"rainfallMM\":22.2}";
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload));
    }

    @Test
    public void saveWhenLandIdInvalid(){
        String payload = "{\"landId\":\"nsucse427\",\"rainfallMM\":22.2}";
        String payload2 = "{\"landId\":22.3,\"rainfallMM\":22.2}";
        String payload3 = "{\"landId\":null,\"rainfallMM\":22.2}";
        String payload4 = "{\"landId\":\"\",\"rainfallMM\":22.2}";
        String payload5 = "{\"landId\":-12,\"rainfallMM\":22.2}";
        String payload6 = "{\"rainfallMM\":22.2}";

        assertEquals(SettingsConstants.successJson,rainfallController.save(payload));
        assertEquals(SettingsConstants.successJson,rainfallController.save(payload2));
        assertEquals(SettingsConstants.successJson,rainfallController.save(payload3));
        assertEquals(SettingsConstants.successJson,rainfallController.save(payload4));
        assertEquals(SettingsConstants.successJson,rainfallController.save(payload5));
        assertEquals(SettingsConstants.successJson,rainfallController.save(payload6));
    }


}
