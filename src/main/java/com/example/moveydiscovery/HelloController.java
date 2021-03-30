package com.example.moveydiscovery;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! Notification microservice is on Kubernetes now!";
    }
}
