package com.example.moveydiscovery.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class HelloController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello! Notification microservice is on Kubernetes now!";
    }

    @GetMapping("/emit/{service}/{message}")
    String emitToMovieQueue(@PathVariable String message , @PathVariable String service) {
        rabbitTemplate.convertAndSend(service+".exchange", service+".routingkey", message);
        return "Message sent";
    }
}
