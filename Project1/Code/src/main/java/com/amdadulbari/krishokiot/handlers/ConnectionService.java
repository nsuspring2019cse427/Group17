package com.amdadulbari.krishokiot.handlers;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionService implements MqttCallback {
    MqttConnectionHandler mqttConnectionHandler;
    ExecutorService executorService = Executors.newFixedThreadPool(100);

    public void connectionLost(Throwable cause) {
        initiateConnections(); // reconnect on lost connection.
    }


    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println(mqttMessage.toString());
    }

    public void deliveryComplete(IMqttDeliveryToken token) {

    }

    public void initiateConnections() {
        mqttConnectionHandler = MqttConnectionHandler.getInstance();
        mqttConnectionHandler.connect();
        mqttConnectionHandler.addCallback(ConnectionService.this);
    }
}
