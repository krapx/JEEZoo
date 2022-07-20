package com.example.jeezoo.playerAnimal.infrastructure.primary;

import java.time.LocalDateTime;

public record UpdatePlayerAnimalRequest(
    Long id,
    Long damage,
    String name,
    String image,
    LocalDateTime creationAt,
    LocalDateTime updatedAt,
    Long playerId,
    Long zooId
) {
}
