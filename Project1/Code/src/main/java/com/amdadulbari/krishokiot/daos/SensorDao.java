package com.amdadulbari.krishokiot.daos;

import com.amdadulbari.krishokiot.constants.HibernateUtil;
import com.amdadulbari.krishokiot.models.SensorsModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SensorDao {
    public boolean save(SensorsModel sensorModel) {
        try {
            Session session = HibernateUtil.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(sensorModel);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public SensorsModel find(String deviceId) {

        return new SensorsModel();
    }

}
