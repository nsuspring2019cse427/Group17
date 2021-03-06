package com.amdadulbari.krishokiot;

import com.amdadulbari.krishokiot.constants.SettingsConstants;
import com.amdadulbari.krishokiot.controllers.RainfallController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RainfallControllerTest {
    RainfallController rainfallController = new RainfallController();

    /* -- Happy Path  -- */
    @Test
    public void saveWhenAllValid() {
        String payload = "{\"landId\":2,\"rainfallMM\":22.2}";
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload));
    }


    /* ---   Tested with invalid Land data      --- */
    @Test
    public void saveWhenLandIdInvalid() {
        String payload = "{\"landId\":\"nsucse427\",\"rainfallMM\":22.2}";
        String payload2 = "{\"landId\":22.3,\"rainfallMM\":22.2}";
        String payload3 = "{\"landId\":null,\"rainfallMM\":22.2}";
        String payload4 = "{\"landId\":\"\",\"rainfallMM\":22.2}";
        String payload5 = "{\"landId\":-12,\"rainfallMM\":22.2}";
        String payload6 = "{\"rainfallMM\":22.2}";

        assertEquals(SettingsConstants.successJson, rainfallController.save(payload));
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload2));
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload3));
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload4));
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload5));
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload6));
    }

    /* ---   Tested with invalid Rainfall data      --- */

    @Test
    public void saveWhenRainfallMMInvalid() {
        String payload = "{\"landId\":12,\"rainfallMM\":\"22.2\"}";
        String payload2 = "{\"landId\":12,\"rainfallMM\":\"\"}";
        String payload3 = "{\"landId\":12,\"rainfallMM\":null}";
        String payload4 = "{\"landId\":12,\"rainfallMM\":58.9999999999999999999999999999999999}";
        String payload5 = "{\"landId\":12,\"rainfallMM\":-999}";
        String payload6 = "{\"landId\":12}";

        assertEquals(SettingsConstants.failedJson, rainfallController.save(payload));
        assertEquals(SettingsConstants.failedJson, rainfallController.save(payload2));
        assertEquals(SettingsConstants.failedJson, rainfallController.save(payload3));
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload4));
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload5));
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload6));
    }

    /* ---   Tested with both invalid Land and Rainfall data      --- */

    @Test
    public void saveWhenBothInvalid() {
        String payload = "{\"landId\":\"12\",\"rainfallMM\":12}";
        String payload2 = "{\"landId\":\"12\",\"rainfallMM\":null}";
        String payload3 = "{\"landId\":null,\"rainfallMM\":null}";
        String payload4 = "{\"landId\":12.22222222222222222,\"rainfallMM\":55.158888888888888}";
        String payload5 = "{\"landId\":-12,\"rainfallMM\":-998}";
        String payload6 = "{}";

        assertEquals(SettingsConstants.failedJson, rainfallController.save(payload));
        assertEquals(SettingsConstants.failedJson, rainfallController.save(payload2));
        assertEquals(SettingsConstants.failedJson, rainfallController.save(payload3));
        assertEquals(SettingsConstants.failedJson, rainfallController.save(payload4));
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload5));
        assertEquals(SettingsConstants.successJson, rainfallController.save(payload6));
    }

}
