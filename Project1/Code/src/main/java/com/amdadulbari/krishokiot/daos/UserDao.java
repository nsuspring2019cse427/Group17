package com.amdadulbari.krishokiot.daos;

import com.amdadulbari.krishokiot.models.UserModel;

public class UserDao {
    public UserModel save(UserModel userModel) {

        return userModel;
    }

    public boolean isValid(String userName, String password) {
        return true;
    }
}
