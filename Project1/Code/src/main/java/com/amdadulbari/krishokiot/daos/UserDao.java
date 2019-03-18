package com.amdadulbari.krishokiot.daos;

import com.amdadulbari.krishokiot.constants.HibernateUtil;
import com.amdadulbari.krishokiot.models.UserModel;
import org.hibernate.Session;

public class UserDao {
    public UserModel save(UserModel userModel) {

        return userModel;
    }

    public boolean isValid(String userName, String password) {
        UserModel userModel = find(userName);
        return userModel.getPassword().equals(password);
    }

    public UserModel find(String id) {
        System.out.println(id);
        Session session = HibernateUtil.getInstance().getSession();
        UserModel userModel = session.find(UserModel.class, id);
        session.close();
        return new UserModel();
    }

}
