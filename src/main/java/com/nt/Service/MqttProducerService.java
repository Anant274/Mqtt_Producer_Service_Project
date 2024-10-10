package com.nt.Service;

import com.nt.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;
import org.springframework.integration.support.MessageBuilder;

@Service
public class MqttProducerService {

    @Autowired
    private MessageChannel mqttOutboundChannel;

    public void sendMessage(User user) {
        System.out.println("Convert user object to string (or JSON) to send as a message");
        String message = "User: " + user.getName() + ", Mobile: " + user.getMobileNumber();

        System.out.println("Build and send the message through the channel");
        mqttOutboundChannel.send(MessageBuilder.withPayload(message).build());
    }
}
