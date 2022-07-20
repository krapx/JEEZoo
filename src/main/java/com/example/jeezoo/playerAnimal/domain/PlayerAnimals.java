package com.example.jeezoo.playerAnimal.domain;

import com.example.jeezoo.player.domain.model.PlayerId;

import java.util.List;
import java.util.Optional;

public interface PlayerAnimals {
    List<PlayerAnimal> findAll();
    Optional<PlayerAnimal> findById(PlayerAnimalId playerAnimalId);
    Optional<PlayerAnimal> findByPlayerId(PlayerId playerId);
    PlayerAnimalId save(PlayerAnimal playerAnimal);
}