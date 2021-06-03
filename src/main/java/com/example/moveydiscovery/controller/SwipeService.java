package com.example.moveydiscovery.controller;

import com.example.moveydiscovery.Swipe;
import com.example.moveydiscovery.SwipeRepository;
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
