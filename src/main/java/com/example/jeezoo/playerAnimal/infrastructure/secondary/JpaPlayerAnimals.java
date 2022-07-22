package com.example.jeezoo.playerAnimal.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPlayerAnimals extends JpaRepository<PlayerAnimalEntity, Long> {
    Optional<PlayerAnimalEntity> findByPlayerId(Long playerId);
    Optional<PlayerAnimalEntity> findAllByZooId(Long zooId);
}
