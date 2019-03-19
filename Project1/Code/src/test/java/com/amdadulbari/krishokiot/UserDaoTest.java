package com.amdadulbari.krishokiot;

import com.amdadulbari.krishokiot.daos.UserDao;
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
        return new String[]{"12345678", "MyPassword","jaaaaaagh", "cancer", "misty", "rationalism", "cseisok", "mostlikely", "bonusmarks"};
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


}