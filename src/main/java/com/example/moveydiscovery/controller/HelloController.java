package com.example.moveydiscovery.controller;

import com.example.moveydiscovery.RabbitMqReceiver;
import com.example.moveydiscovery.entity.Swipe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class HelloController {

    private final RabbitMqReceiver rabbitMqReceiver;

    @GetMapping("/rabbit")
    public String listenRabbit() {
        try {
            return rabbitMqReceiver.getSwipes().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "listener error";
        }
    }
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! Notification microservice is on Kubernetes now!";
    }
}
