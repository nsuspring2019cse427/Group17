package com.amdadulbari.krishokiot.daos;

import com.amdadulbari.krishokiot.constants.HibernateUtil;
import com.amdadulbari.krishokiot.models.LandModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class LandDao {
    public boolean save(LandModel landModel) {
        try {
            System.out.println(landModel.toString());
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
