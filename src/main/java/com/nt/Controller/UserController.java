package com.nt.Controller;

import com.nt.Entity.User;
import com.nt.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//this project will work if and only if the C:\Program Files\mosquitto messaging application is install in the system
// and before starting the producer and consumer project we have to run this mosquitto application the run file is present
// with name "mosquitto" and File Type is Application just double-click on that file to run in background
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        System.out.println("initial starting point");
        userService.createUser(user);
        return "User created and message sent to MQTT topic.";
    }
}
