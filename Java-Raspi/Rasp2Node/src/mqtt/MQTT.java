/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mqtt;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 *
 * @author aker99
 */
public final class MQTT  { 
    private int qos;
    private String broker;
    private String clientId;
    private String username; 
    private String password; 
    private  MemoryPersistence persistence = new MemoryPersistence();
    private  MqttClient sampleClient;
    
    public MQTT(String broker,String clientId,String username,String password){
        setQos(2);
        setBroker(broker);
        setClientId(clientId);    
        setPassword(password);
        setUsername(username);
    }
    public MQTT(String broker,String clientId){
        setQos(2);
        setBroker(broker);
        setClientId(clientId);   
    }
    
    public void setQos(int qos) {
        this.qos = qos;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setPersistence(MemoryPersistence persistence) {
        this.persistence = persistence;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean connect(){
        try {   
            sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            connOpts.setAutomaticReconnect(true);
            if(username!=null){
                connOpts.getUserName();
                connOpts.getPassword();
            }
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            return true;
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
            return false;
        }
    }
    public boolean subscribe(String sub){
        try {
            sampleClient.subscribe(sub);
            return true;
        } catch (MqttException ex) {
            Logger.getLogger(MQTT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public void setCallBack(MqttCallback callback){
        sampleClient.setCallback(callback);
    }
    public boolean publish(String topic,String msg){
         MqttMessage message = new MqttMessage(msg.getBytes());
         message.setQos(qos);
        try {
            sampleClient.publish(topic, message);
            return true;
        } catch (MqttException ex) {
            Logger.getLogger(MQTT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
