package com.example.jeezoo.playerAnimal.infrastructure.primary;

import com.example.jeezoo.playerAnimal.domain.PlayerAnimal;

import java.time.LocalDateTime;

public record PlayerAnimalResponse(
    Long id,
    Long damage,
    String name,
    String image,
    LocalDateTime creationAt,
    LocalDateTime updatedAt,
    Long playerId,
    Long zooId
) {
    public static PlayerAnimalResponse fromPlayerAnimal(PlayerAnimal playerAnimal) {
        return new PlayerAnimalResponse(
            playerAnimal.getId().getValue(),
            playerAnimal.getDamage().getValue(),
            playerAnimal.getName(),
            playerAnimal.getImage(),
            playerAnimal.getCreationAt(),
            playerAnimal.getUpdatedAt(),
            playerAnimal.getPlayerId().getValue(),
            playerAnimal.getZooId().getValue()
        );
    }
}
