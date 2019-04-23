/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raspi2node;
import mqtt.*;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author aker99
 */
public class LocalNode implements MqttCallback{
    
    MQTT iotHub;
    
      @Override
    public void messageArrived(String topic,MqttMessage msg){
        IoTHub hub = new IoTHub();
        hub.publish(topic, msg.toString());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void connectionLost(Throwable thrwbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    public LocalNode(){
        iotHub = new MQTT("broker.mqttdashboard.com","CentralHub");
        iotHub.connect();
        iotHub.subscribe("Temp");
        iotHub.setCallBack(this);
    }    
     public boolean publish(String topic,String msg){
        return iotHub.publish(topic, msg);
    }
}
