package com.amdadulbari.krishokiot;

import com.amdadulbari.krishokiot.constants.SettingsConstants;
import com.amdadulbari.krishokiot.daos.UserDao;
import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class UserDaoTest {
    @DataPoint
    public static String name = "amdadulbariimad";
    @DataPoint
    public static String[] usernames = {"imad", "amdadul", "bari"};

    UserDao userDao = new UserDao();


    @DataPoints
    public static String[] names() {
        return new String[]{"12345678", "MyPassword", "jaaaaaagh", "cancer", "misty", "rationalism", "cseisok", "mostlikely", "bonusmarks", "", null};
    }


    @Theory
    public void isValid(String firstPart, String secondPart) throws Exception {
        System.out.println(String.format("Testing with %s and %s", firstPart, secondPart));
        assumeNotNull(firstPart, secondPart);
        assumeThat(firstPart, notNullValue());
        assumeThat(secondPart, notNullValue());
        boolean actual = userDao.isValid(firstPart, secondPart);
        System.out.println(actual);
        assertEquals(true, actual);
    }

    @Test
    public void saveWhenAllValid() {
        String payload = "{\"name\":\"imad\",\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";

        assertEquals(SettingsConstants.successJson, userDao.save(payload));

    }

    @Test
    public void saveWhenNameInValid() {
        String payload = "{\"name\":\"\",\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload2 = "{\"name\":00,\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload3 = "{\"name\":12.2,\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload4 = "{\"name\":null,\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload5 = "{\"name\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload6 = "{\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload7 = "{\"name\":\"!@###!@!@!@!@!@&*()\",\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        assertEquals(SettingsConstants.successJson, userDao.save(payload));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload2));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload3));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload4));
        assertEquals(SettingsConstants.successJson, userDao.save(payload5));
        assertEquals(SettingsConstants.successJson, userDao.save(payload6));
        assertEquals(SettingsConstants.successJson, userDao.save(payload7));

    }

    @Test
    public void saveWhenPhoneInvalid() {
        String payload = "{\"phoneNumber\":\"\",\"name\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload2 = "{\"phoneNumber\":00,\"name\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload3 = "{\"phoneNumber\":12.2,\"name\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload4 = "{\"phoneNumber\":null,\"name\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload5 = "{\"phoneNumber\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"name\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload6 = "{\"name\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload7 = "{\"phoneNumber\":\"!@###!@!@!@!@!@&*()\",\"name\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        assertEquals(SettingsConstants.successJson, userDao.save(payload));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload2));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload3));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload4));
        assertEquals(SettingsConstants.successJson, userDao.save(payload5));
        assertEquals(SettingsConstants.successJson, userDao.save(payload6));
        assertEquals(SettingsConstants.successJson, userDao.save(payload7));
    }

    @Test
    public void saveWhenAddressInvalid() {
        String payload = "{\"name\":\"\",\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload2 = "{\"name\":00,\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload3 = "{\"name\":12.2,\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload4 = "{\"name\":null,\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload5 = "{\"name\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload6 = "{\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        String payload7 = "{\"name\":\"!@###!@!@!@!@!@&*()\",\"phoneNumber\":\"01888880000\",\"address\":\"Bashundhara R/A\",\"password\":\"!@#abc#$%\",\"age\":99}";
        assertEquals(SettingsConstants.successJson, userDao.save(payload));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload2));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload3));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload4));
        assertEquals(SettingsConstants.successJson, userDao.save(payload5));
        assertEquals(SettingsConstants.successJson, userDao.save(payload6));
        assertEquals(SettingsConstants.successJson, userDao.save(payload7));
    }

    @Test
    public void saveWhenPasswordInvalid() {
        String payload = "{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":\"a\",\"age\":100}";
        String payload2 = "{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":\"aaaaaaaa\",\"age\":100}";
        String payload3 = "{{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":null,\"age\":100}";
        String payload4 = "{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":123,\"age\":100}";
        String payload5 = "{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":12.22,\"age\":100}";
        String payload6 = "{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":-12.22,\"age\":100}";
        assertEquals(SettingsConstants.failedJson, userDao.save(payload));
        assertEquals(SettingsConstants.successJson, userDao.save(payload2));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload3));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload4));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload5));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload6));
    }

    @Test
    public void saveWhenAgeInvalid() {
        String payload = "{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":\"abcfwe!@#A\",\"age\":-100}";
        String payload2 = "{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":\"abcfwe!@#A\",\"age\":\"nsu\"}";
        String payload3 = "{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":\"abcfwe!@#A\",\"age\":null}";
        String payload4 = "{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":\"abcfwe!@#A\",\"age\":12.22}";
        String payload5 = "{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":\"abcfwe!@#A\",\"age\":-12.22}";
        String payload6 = "{\"name\":\"imad\",\"phoneNumber\":\"+8801155441122\",\"address\":\"Mirpur\",\"password\":\"abcfwe!@#A\"}";

        assertEquals(SettingsConstants.failedJson, userDao.save(payload));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload2));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload3));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload4));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload5));
        assertEquals(SettingsConstants.failedJson, userDao.save(payload6));
    }


}