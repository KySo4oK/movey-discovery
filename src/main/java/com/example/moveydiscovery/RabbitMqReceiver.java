package com.example.moveydiscovery;

import com.example.moveydiscovery.entity.Swipe;
import com.example.moveydiscovery.service.SwipeService;
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
    SwipeService swipeService;
    List<Swipe> swipes = new ArrayList<>();

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(Swipe message) {
        swipes.add(message);
        swipeService.save(message);
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}
