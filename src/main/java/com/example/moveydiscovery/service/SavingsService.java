package com.example.moveydiscovery.service;

import com.example.moveydiscovery.entity.Saving;
import com.example.moveydiscovery.repository.SavingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SavingsService {
    private final SavingRepository savingRepository;
    public void save(Saving saving) {
        savingRepository.save(saving);
    }

    public List<Saving> findAll(String userId) {
        return savingRepository.findAllByUserId(userId);
    }
}
