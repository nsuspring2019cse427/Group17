package com.amdadulbari.krishokiot.daos;

import com.amdadulbari.krishokiot.constants.HibernateUtil;
import com.amdadulbari.krishokiot.constants.SettingsConstants;
import com.amdadulbari.krishokiot.models.UserModel;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.hibernate.Session;

public class UserDao {
    public String save(String payload) {
        try {
            JsonObject payloadObject = Json.parse(payload).asObject();
            String name = payloadObject.getString("name", "");
            String phoneNumber = payloadObject.getString("phoneNumber", "");
            String address = payloadObject.getString("address", "");
            String password = payloadObject.getString("password", "");
            int age = payloadObject.getInt("age", 0);

            if (password.length() > 7 && age>1) {
                UserModel userModel = new UserModel();
                userModel.setName(name);
                userModel.setAddress(address);
                userModel.setAge(age);
                userModel.setPhoneNumber(phoneNumber);
                userModel.setPassword(password);
            /*Session session = HibernateUtil.getInstance().getSession();
            Transaction transaction = session.beginTransaction();
            session.save(userModel);
            transaction.commit();
            session.close();*/
                return SettingsConstants.successJson;
            }


        } catch (Exception e) {
            return SettingsConstants.failedJson;
        }
        return SettingsConstants.failedJson;
    }

    public boolean isValid(String userName, String password) {
        if (userName != null && !userName.trim().isEmpty()) {
            //UserModel userModel = find(userName);
//return userModel.getPassword().equals(password);
            return password.length() > 7;
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
