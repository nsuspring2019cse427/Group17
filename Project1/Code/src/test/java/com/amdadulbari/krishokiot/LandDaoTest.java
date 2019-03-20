package com.amdadulbari.krishokiot;

import com.amdadulbari.krishokiot.daos.LandDao;
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

    /* -- Constructor to set values from parameterized collection and get from test methods --  */
    public LandDaoTest(LandModel landModel, boolean expectedResult) {
        this.landModel = landModel;
        this.expectedResult = expectedResult;
    }

    /* -- Inputs for parameterized Test -- */
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new LandModel(1024.4f, "ABC", 0.4, 58.45), true}, {new LandModel(-424.4f, "ABC", 198.34, 25058.45), true}, {new LandModel(1024.4f, null, 98.34, 58.45), true}, {new LandModel(0.0, null, 0.0, 0.0), true}
        });
    }

    @Before
    public void setUp() throws Exception {
        landDao = new LandDao();
    }

    /* -- Test with different land models which is collected from parameterized collection -- */
    @Test
    public void save() {
        System.out.println(landModel.toString());
        boolean result = landDao.save(landModel);
        assertEquals(expectedResult, result);
    }
}