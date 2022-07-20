package com.example.jeezoo.playerAnimal.domain;

import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.playerAnimal.domain.exception.PlayerAnimalNotFoundException;
import com.example.jeezoo.zoo.domain.ZooService;
import org.springframework.stereotype.Component;

@Component
public class PlayerAnimalService {

    private final PlayerAnimals playerAnimals;
    private final ZooService zooService;

    public PlayerAnimalService(PlayerAnimals playerAnimals, ZooService zooService) {
        this.playerAnimals = playerAnimals;
        this.zooService = zooService;
    }

    public PlayerAnimal findByPlayerId(PlayerId playerId) {
        // Validation UserId
        return playerAnimals.findByPlayerId(playerId).orElseThrow(() -> new PlayerAnimalNotFoundException(playerId));
    }

    public PlayerAnimal findById(PlayerAnimalId playerAnimalId) {
        return playerAnimals.findById(playerAnimalId).orElseThrow(() -> new PlayerAnimalNotFoundException(playerAnimalId));
    }

    public PlayerAnimalId create(PlayerAnimal playerAnimal) {
        return playerAnimals.save(playerAnimal);
    }

    public PlayerAnimalId update(PlayerAnimal playerAnimal) {
        findById(playerAnimal.getId());
        zooService.getZooById(playerAnimal.getZooId());
        return playerAnimals.save(playerAnimal);
    }
}
