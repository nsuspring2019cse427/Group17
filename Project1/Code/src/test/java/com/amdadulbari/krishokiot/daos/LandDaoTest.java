package com.amdadulbari.krishokiot.daos;

import com.amdadulbari.krishokiot.models.LandModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LandDaoTest {
    private LandModel landModel;
    private LandDao landDao;
    private boolean expectedResult;

    public LandDaoTest(LandModel landModel, boolean expectedResult) {
        this.landModel = landModel;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new LandModel(1024.4f, "ABC", 98.34, 58.45), true}, {new LandModel(1024.4f, "ABC", 98.34, 58.45), true}, {new LandModel(1024.4f, null, 98.34, 58.45), true}
        });
    }

    @Before
    public void setUp() throws Exception {
        landDao = new LandDao();
    }

    @Test
    public void save() {
        System.out.println(landModel.toString());
        boolean result = landDao.save(landModel);
        assertEquals(expectedResult,result);
    }
}