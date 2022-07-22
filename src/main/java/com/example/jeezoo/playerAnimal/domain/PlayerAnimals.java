package com.example.jeezoo.playerAnimal.domain;

import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.zoo.domain.ZooId;

import java.util.List;
import java.util.Optional;

public interface PlayerAnimals {
    List<PlayerAnimal> findAll();
    Optional<PlayerAnimal> findById(PlayerAnimalId playerAnimalId);
    Optional<PlayerAnimal> findByPlayerId(PlayerId playerId);
    List<PlayerAnimal> findAllByPlayerIdAndZooId(PlayerId playerId, ZooId zooId);
    List<PlayerAnimal> findAllByZooId(ZooId zooId);
    PlayerAnimalId save(PlayerAnimal playerAnimal);
}