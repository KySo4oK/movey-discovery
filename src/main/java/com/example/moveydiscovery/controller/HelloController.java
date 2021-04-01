package com.example.moveydiscovery.controller;

import com.example.moveydiscovery.service.SimpleKafkaConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class HelloController {
    private final SimpleKafkaConsumerService consumerService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! Notification microservice is on Kubernetes now!";
    }

    @GetMapping("/kafka")
    public String getMessage() {
        return consumerService.getMessages().toString();
    }
}
