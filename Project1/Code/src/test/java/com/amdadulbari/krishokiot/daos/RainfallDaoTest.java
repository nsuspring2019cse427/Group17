package com.amdadulbari.krishokiot.daos;

import com.amdadulbari.krishokiot.models.LandModel;
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

    public RainfallDaoTest(RainfallModel rainfallModel, boolean expectedResult) {
        this.rainfallModel = rainfallModel;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new RainfallModel(0, 0, 98.34f), true}
        });
    }

    @Before
    public void setUp() throws Exception {
        rainfallDao = new RainfallDao();
    }

    @Test
    public void save() {
        System.out.println(rainfallModel.toString());
        boolean result = rainfallDao.save(rainfallModel);
        assertEquals(expectedResult, result);
    }
}