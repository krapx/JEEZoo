package com.example.jeezoo.playerAnimal.infrastructure.primary;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record CreatePlayerAnimalRequest(
    @NotEmpty
    String name,
    @NotEmpty
    String image,
    @NotNull
    Long playerId,
    @NotNull
    Long zooId
) {
}
