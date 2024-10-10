package com.nt.Service;

import com.nt.Entity.User;
import com.nt.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MqttProducerService mqttProducerService; // Assuming you already have this service

    public void createUser(User user) {
        System.out.println("record store in db");
        User savedUser = userRepository.save(user);

        System.out.println("Send user data to MQTT broker");
        mqttProducerService.sendMessage(savedUser);
    }
}
