package com.example.moveydiscovery.controller;

import com.example.moveydiscovery.entity.Saving;
import com.example.moveydiscovery.service.SavingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/savings")
public class SavingController {
    private final SavingsService service;

    @PostMapping("/{userId}/{movieId}")
    void saveSwipe(@PathVariable("userId") String userId, @PathVariable("movieId") String movieId) {
        service.save(new Saving(userId, movieId));
    }

    @GetMapping("/{userId}")
    List<String> getMovieIds(@PathVariable("userId") String userId) {
        return service.findAll(userId).stream()
                .map(Saving::getMovieId)
                .collect(Collectors.toList());
    }
}
