package com.amdadulbari.krishokiot;

import com.amdadulbari.krishokiot.controllers.LandController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LandControllerTest {
    LandController landController = new LandController();

    @Test
    public void saveLandWhenAllValid() {
        String payload = "{\"landType\":\"crops\",\"sqft\":10.0,\"lat\":40.0,\"lon\":60.0}";
        assertEquals(true, landController.saveLand(payload));

    }

    @Test
    public void saveLandWhenSQFTInvalid() {
        String payload = "{\"landType\":\"crops\",\"sqft\":-10.0,\"lat\":40.0,\"lon\":60.0}";
        String payload2 = "{\"landType\":\"crops\",\"sqft\":-100,\"lat\":40.0,\"lon\":60.0}";
        String payload3 = "{\"landType\":\"crops\",\"sqft\":null,\"lat\":40.0,\"lon\":60.0}";
        String payload4 = "{\"landType\":\"crops\",\"sqft\":\"\",\"lat\":40.0,\"lon\":60.0}";
        String payload5 = "{\"landType\":\"crops\",\"sqft\":\"55555555555555555555555555555\",\"lat\":40.0,\"lon\":60.0}";

        assertEquals(false, landController.saveLand(payload));
        assertEquals(false, landController.saveLand(payload2));
        assertEquals(false, landController.saveLand(payload3));
        assertEquals(false, landController.saveLand(payload4));
        assertEquals(false, landController.saveLand(payload5));

    }

    @Test
    public void saveLandWhenLandTypeInvalid() {
        String payload1 = "{\"landType\":123,\"sqft\":20.0,\"lat\":40.0,\"lon\":60.0}";
        String payload2 = "{\"landType\":null,\"sqft\":20.0,\"lat\":40.0,\"lon\":60.0}";
        String payload3 = "{\"landType\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"sqft\":20.0,\"lat\":40.0,\"lon\":60.0}";
        String payload4 = "{\"landType\":\"!@#$@#$##$#$#$%%\",\"sqft\":20.0,\"lat\":40.0,\"lon\":60.0}";
        String payload5 = "{\"landType\":52.3,\"sqft\":20.0,\"lat\":40.0,\"lon\":60.0}";
        String payload6 = "{\"landType\":\"\",\"sqft\":20.0,\"lat\":40.0,\"lon\":60.0}";

        assertEquals(false, landController.saveLand(payload1));
        assertEquals(false, landController.saveLand(payload2));
        assertEquals(false, landController.saveLand(payload3));
        assertEquals(false, landController.saveLand(payload4));
        assertEquals(false, landController.saveLand(payload5));
        assertEquals(false, landController.saveLand(payload6));
    }

    @Test
    public void saveLandWhenLatInvalid() {
        String payload = "{\"landType\":\"crops\",\"lat\":-10.0,\"sqft\":40.0,\"lon\":60.0}";
        String payload2 = "{\"landType\":\"crops\",\"lat\":-100,\"sqft\":40.0,\"lon\":60.0}";
        String payload3 = "{\"landType\":\"crops\",\"lat\":null,\"sqft\":40.0,\"lon\":60.0}";
        String payload4 = "{\"landType\":\"crops\",\"lat\":\"\",\"sqft\":40.0,\"lon\":60.0}";
        String payload5 = "{\"landType\":\"crops\",\"lat\":\"55555555555555555555555555555\",\"sqft\":40.0,\"lon\":60.0}";

        assertEquals(false, landController.saveLand(payload));
        assertEquals(false, landController.saveLand(payload2));
        assertEquals(false, landController.saveLand(payload3));
        assertEquals(false, landController.saveLand(payload4));
        assertEquals(false, landController.saveLand(payload5));
    }

    @Test
    public void saveLandWhenLonInvalid() {
        String payload = "{\"landType\":\"crops\",\"lat\":-10.0,\"lon\":40.0,\"sqft\":60.0}";
        String payload2 = "{\"landType\":\"crops\",\"lat\":-100,\"lon\":40.0,\"sqft\":60.0}";
        String payload3 = "{\"landType\":\"crops\",\"lat\":null,\"lon\":40.0,\"sqft\":60.0}";
        String payload4 = "{\"landType\":\"crops\",\"lat\":\"\",\"lon\":40.0,\"sqft\":60.0}";
        String payload5 = "{\"landType\":\"crops\",\"lat\":\"55555555555555555555555555555\",\"lon\":40.0,\"sqft\":60.0}";

        assertEquals(false, landController.saveLand(payload));
        assertEquals(false, landController.saveLand(payload2));
        assertEquals(false, landController.saveLand(payload3));
        assertEquals(false, landController.saveLand(payload4));
        assertEquals(false, landController.saveLand(payload5));
    }

    @Test
    public void saveLandWhenLanLonInvalid() {
        String payload = "{\"landType\":\"crops\",\"lat\":-10.0,\"lon\":-10.0,\"sqft\":60.0}";
        String payload2 = "{\"landType\":\"crops\",\"lat\":-100,\"lon\":null,\"sqft\":60.0}";
        String payload3 = "{\"landType\":\"crops\",\"lat\":null,\"lon\":-100,\"sqft\":60.0}";
        String payload4 = "{\"landType\":\"crops\",\"sqft\":20.0,\"lat\":\"\",\"lon\":\"\"}";
        String payload5 = "{\"landType\":\"crops\",\"lat\":\"55555555555555555555555555555\",\"lon\":40.0,\"sqft\":60.0}";

        assertEquals(false, landController.saveLand(payload));
        assertEquals(false, landController.saveLand(payload2));
        assertEquals(false, landController.saveLand(payload3));
        assertEquals(false, landController.saveLand(payload4));
        assertEquals(false, landController.saveLand(payload5));
    }

    @Test
    public void saveLandWhenSQFTLatInvalid() {
        String payload = "{\"landType\":\"crops\",\"sqft\":-20.0,\"lat\":\"\",\"lon\":12.22}";
        String payload2 = "{\"landType\":\"crops\",\"sqft\":\"\",\"lat\":-66,\"lon\":12.22}";
        String payload3 = "{\"landType\":\"crops\",\"sqft\":null,\"lat\":\"abc\",\"lon\":12.22}";
        String payload4 = "{\"landType\":\"crops\",\"sqft\":\"\",\"lat\":\"\",\"lon\":12.22}";
        String payload5 = "{\"landType\":\"crops\",\"sqft\":-1200,\"lat\":2580,\"lon\":12.22}";

        assertEquals(false, landController.saveLand(payload));
        assertEquals(false, landController.saveLand(payload2));
        assertEquals(false, landController.saveLand(payload3));
        assertEquals(false, landController.saveLand(payload4));
        assertEquals(false, landController.saveLand(payload5));
    }

    @Test
    public void saveLandWhenSQFTLonInvalid() {
        String payload = "{\"landType\":\"crops\",\"sqft\":-20.0,\"lon\":\"\",\"lat\":12.22}";
        String payload2 = "{\"landType\":\"crops\",\"sqft\":\"\",\"lon\":-66,\"lat\":12.22}";
        String payload3 = "{\"landType\":\"crops\",\"sqft\":null,\"lon\":\"abc\",\"lat\":12.22}";
        String payload4 = "{\"landType\":\"crops\",\"sqft\":\"\",\"lon\":\"\",\"lat\":12.22}";
        String payload5 = "{\"landType\":\"crops\",\"sqft\":-1200,\"lon\":2580,\"lat\":12.22}";

        assertEquals(false, landController.saveLand(payload));
        assertEquals(false, landController.saveLand(payload2));
        assertEquals(false, landController.saveLand(payload3));
        assertEquals(false, landController.saveLand(payload4));
        assertEquals(false, landController.saveLand(payload5));
    }

}