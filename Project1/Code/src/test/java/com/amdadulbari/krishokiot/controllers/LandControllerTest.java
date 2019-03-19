package com.amdadulbari.krishokiot.controllers;

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

    }

    @Test
    public void saveLandWhenLonInvalid() {

    }

}