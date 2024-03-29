package com.example.jeezoo.playerAnimal.infrastructure.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaPlayerAnimals extends JpaRepository<PlayerAnimalEntity, Long> {
    Optional<PlayerAnimalEntity> findFirstByZooId(Long zooId);
    List<PlayerAnimalEntity> findAllByZooId(Long zooId);
    List<PlayerAnimalEntity> findAllByPlayerIdAndZooId(Long playerId, Long zooId);
}
