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
                {new SensorsModel("IP-01", 5555555555f, 55f), true},
                {new SensorsModel("IP-02", 445f, 7f), true},
                {new SensorsModel("IP-03", 100000000000000f, 700000000000000000000000000f), true},
                {new SensorsModel("IP-04", 20000404000003000f, 6000f), true},
                {new SensorsModel("IP-05", 10f, 93f), true},
                {new SensorsModel("IP-06", 100000000000000f, 700000000000000000000000000f), true},

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

    @Test
    public void find() {
        SensorsModel actualModel = sensorDao.find(this.sensorsModel.getDeviceID());
        assertEquals(sensorsModel,actualModel);
    }
}