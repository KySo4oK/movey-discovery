package com.example.moveydiscovery.repository;

import com.example.moveydiscovery.entity.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingRepository extends JpaRepository<Saving, Long> {
    List<Saving> findAllByUserId(String userId);
}
