package com.example.moveydiscovery.service;

import com.example.moveydiscovery.entity.Swipe;
import com.example.moveydiscovery.repository.SwipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SwipeService {
    private final SwipeRepository repository;

    public void save(Swipe swipe) {
        repository.save(swipe);
    }
}
