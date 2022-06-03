package com.example.jeezoo.zoo.infrastructure.secondary.jpa;

import com.example.jeezoo.zoo.infrastructure.secondary.jpa.entity.ZooEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaZoos extends JpaRepository<ZooEntity, Long> {
}
