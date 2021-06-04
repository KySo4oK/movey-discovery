package com.example.moveydiscovery;

import com.example.moveydiscovery.entity.Saving;
import com.example.moveydiscovery.service.SavingsService;
import lombok.Getter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class RabbitMqReceiver implements RabbitListenerConfigurer {

    @Autowired
    SavingsService savingsService;
    List<Saving> swipes = new ArrayList<>();

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(Saving message) {
        swipes.add(message);
        savingsService.save(message);
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}
