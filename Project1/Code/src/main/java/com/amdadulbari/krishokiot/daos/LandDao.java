package com.amdadulbari.krishokiot.daos;

import com.amdadulbari.krishokiot.constants.HibernateUtil;
import com.amdadulbari.krishokiot.models.LandModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LandDao {
    public boolean save(LandModel landModel) {
        try {
            Session session = HibernateUtil.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(landModel);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
