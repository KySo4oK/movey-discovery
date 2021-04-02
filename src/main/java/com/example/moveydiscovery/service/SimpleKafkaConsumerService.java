package com.example.moveydiscovery.service;

import lombok.Getter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleKafkaConsumerService {
    @Getter
    private List<String> messages = new ArrayList<>();

    @KafkaListener(groupId = "notifications", topics = "movie")
    public void consume(String message) {
        messages.add(message);
    }
}
