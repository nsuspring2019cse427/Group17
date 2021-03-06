package com.amdadulbari.krishokiot;

import com.amdadulbari.krishokiot.daos.RainfallDao;
import com.amdadulbari.krishokiot.models.RainfallModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RainfallDaoTest {
    private RainfallModel rainfallModel;
    private RainfallDao rainfallDao;
    private boolean expectedResult;

    /* -- Constructor to set values from parameterized collection and get from test methods --  */

    public RainfallDaoTest(RainfallModel rainfallModel, boolean expectedResult) {
        this.rainfallModel = rainfallModel;
        this.expectedResult = expectedResult;
    }

    /* -- Inputs for parameterized Test -- */

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new RainfallModel(0, 0, 98.34f), true},
                {new RainfallModel(1, 0, 56.20f), true},
                {new RainfallModel(2, 0, 44.50f), true},
                {new RainfallModel(3, 0, 99.99f), true},
                {new RainfallModel(4, 0, 0.00f), false},
                {new RainfallModel(5, 0, 56.78f), true},
                {new RainfallModel(6, 0, 33.33f), true},
                {new RainfallModel(7, 0, 77.78f), true},
                {new RainfallModel(8, 0, 48.14f), true},
                {new RainfallModel(9, 0, 11.12f), true},
                {new RainfallModel(10, 0, 29.69f), true},
        });
    }

    @Before
    public void setUp() throws Exception {
        rainfallDao = new RainfallDao();
    }

    /* -- Getting the inputs from the global rainfallModel and expectedResult which are initialized by constructor -- */
    @Test
    public void save() {
        System.out.println(rainfallModel.toString());
        boolean result = rainfallDao.save(rainfallModel);
        assertEquals(expectedResult, result);
    }
}