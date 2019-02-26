package com.amdadulbari.krishokiot.daos;

import com.amdadulbari.krishokiot.models.SensorsModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SensorDaoTest {
    private SensorDao sensorDao;
    private SensorsModel sensorsModel;
    private boolean expectedResult;

    public SensorDaoTest(SensorsModel sensorsModel, boolean expectedResult) {
        this.sensorsModel = sensorsModel;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new SensorsModel("aaa", 44f, 55f), true}, {new SensorsModel("aaac", 445f, 7f), true},{new SensorsModel("aaac", 100000000000000f, 700000000000000000000000000f), true}
        });
    }

    @Before
    public void setUp() throws Exception {
        sensorDao = new SensorDao();
    }

    @Test
    public void save() {
        System.out.println(sensorsModel.toString());
        boolean result = sensorDao.save(sensorsModel);
        assertEquals(expectedResult, result);
    }
}