package com.amdadulbari.krishokiot.daos;

import com.amdadulbari.krishokiot.constants.HibernateUtil;
import com.amdadulbari.krishokiot.models.UserModel;
import org.hibernate.Session;

public class UserDao {
    public UserModel save(UserModel userModel) {

        return userModel;
    }

    public boolean isValid(String userName, String password) {
        if (userName != null && !userName.trim().isEmpty()) {
            if (password.length() > 7) {
                //UserModel userModel = find(userName);
                //return userModel.getPassword().equals(password);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public UserModel find(String id) {
        System.out.println(id);
        Session session = HibernateUtil.getInstance().getSession();
        UserModel userModel = session.find(UserModel.class, id);
        session.close();
        return new UserModel();
    }

}
