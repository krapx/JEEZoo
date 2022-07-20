package com.example.jeezoo.zoo.infrastructure.secondary.jpa;

import com.example.jeezoo.zoo.infrastructure.secondary.jpa.entity.ZooEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaZoos extends JpaRepository<ZooEntity, Long> {
    List<ZooEntity> findAllByUserId(Long userId);
}
