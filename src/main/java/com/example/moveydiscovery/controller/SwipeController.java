package com.example.moveydiscovery.controller;

import com.example.moveydiscovery.entity.Swipe;
import com.example.moveydiscovery.service.SwipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/swipes")
public class SwipeController {
    private final SwipeService swipeService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    void saveSwipe(@RequestBody Swipe swipe) {
        swipeService.save(swipe);
    }
}
