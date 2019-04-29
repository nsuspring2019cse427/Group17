package com.amdadulbari.krishokiot.controllers;

import com.amdadulbari.krishokiot.constants.SettingsConstants;
import com.amdadulbari.krishokiot.daos.UserDao;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("api/login")
    public String login(@RequestBody  String payload) {
        System.out.println("payload = "+payload);
        JsonObject payloadObject = Json.parse(payload).asObject();
        String email = payloadObject.getString("email", "");
        String password = payloadObject.getString("password", "");
        UserDao userDao = new UserDao();
        boolean result = userDao.isValid(email, password);
        if (result) {
            return SettingsConstants.successJson;
        } else {
            return SettingsConstants.failedJson;
        }
    }
}
