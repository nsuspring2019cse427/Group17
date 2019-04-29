package com.amdadulbari.krishokiot;

import com.amdadulbari.krishokiot.daos.SensorDao;
import com.amdadulbari.krishokiot.daos.UserDao;
import com.amdadulbari.krishokiot.handlers.ConnectionService;
import com.amdadulbari.krishokiot.models.SensorsModel;
import com.amdadulbari.krishokiot.models.UserModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KrishokiotApplication {

    public static void main(String[] args) {
        SpringApplication.run(KrishokiotApplication.class, args);
 /*       ConnectionService connectionService = new ConnectionService();
        connectionService.initiateConnections();*/


        SensorsModel sensorsModel = new SensorsModel();
        sensorsModel.setTemp(10.2f);
        sensorsModel.setHumidity(22.2f);
        sensorsModel.setDeviceID("asd");
        sensorsModel.setId(22);

        SensorDao sensorDao = new SensorDao();
        sensorDao.save(sensorsModel);

        UserDao userDao = new UserDao();
        userDao.save("aaa");

    }

}
