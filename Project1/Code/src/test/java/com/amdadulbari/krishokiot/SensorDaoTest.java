package com.amdadulbari.krishokiot;

import com.amdadulbari.krishokiot.daos.SensorDao;
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

    /* Constructor for setting up parameterized collection data and getting from the test methods */
    public SensorDaoTest(SensorsModel sensorsModel, boolean expectedResult) {
        this.sensorsModel = sensorsModel;
        this.expectedResult = expectedResult;
    }

    /* -- Parameterized Collection of different kind of SensorModel which contains different types of inputs/values-- */
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new SensorsModel("IP-01", 5555555555f, 55f), false},
                {new SensorsModel("IP-02", 445f, 7f), false},
                {new SensorsModel("IP-03", 100000000000000f, 700000000000000000000000000f), false},
                {new SensorsModel("IP-04", 20000404000003000f, 6000f), false},
                {new SensorsModel("IP-05", 10f, 93f), true},
                {new SensorsModel("IP-07", 0f, 0f), false},
                {new SensorsModel("IP-08", -1f, 54f), true},
                {new SensorsModel("IP-09", 110f, 4000f), true},
                {new SensorsModel("IP-10", 75f, 0f), true},
                {new SensorsModel("IP-11", 0.5555f, 0f), false},
                {new SensorsModel("IP-12", -10f, 30f), true},
        });
    }

    @Before
    public void setUp() throws Exception {
        sensorDao = new SensorDao();
    }

    /* checks the save method by using the parameters as input*/
    @Test
    public void save() {
        System.out.println(sensorsModel.toString());
        boolean result = sensorDao.save(sensorsModel);
        assertEquals(expectedResult, result);
    }

    /* checks the find method by using the parameters as input*/
    @Test
    public void find() {
        SensorsModel actualModel = sensorDao.find(this.sensorsModel.getDeviceID());
        assertEquals(sensorsModel, actualModel);
    }
}