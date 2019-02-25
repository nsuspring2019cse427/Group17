package com.amdadulbari.krishokiot;

import com.amdadulbari.krishokiot.handlers.ConnectionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KrishokiotApplication {

    public static void main(String[] args) {
        SpringApplication.run(KrishokiotApplication.class, args);
        ConnectionService connectionService = new ConnectionService();
        connectionService.initiateConnections();
    }

}
