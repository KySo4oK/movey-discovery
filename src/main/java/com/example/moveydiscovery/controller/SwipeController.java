package com.example.moveydiscovery.controller;

import com.example.moveydiscovery.Swipe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/swipes")
@RequiredArgsConstructor
public class SwipeController {
    private final SwipeService swipeService;

    @PostMapping
    public void saveSwipe(@RequestBody Swipe swipe) {
        swipeService.save(swipe);
    }
}
