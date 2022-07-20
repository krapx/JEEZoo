package com.example.jeezoo.zoo.infrastructure.secondary.jpa;

import com.example.jeezoo.zoo.infrastructure.secondary.jpa.entity.ZooEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaZoos extends JpaRepository<ZooEntity, Long> {
    List<ZooEntity> findAllByPlayerId(Long playerId);
}
