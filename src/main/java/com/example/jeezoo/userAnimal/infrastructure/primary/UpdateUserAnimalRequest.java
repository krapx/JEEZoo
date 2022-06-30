package com.example.jeezoo.userAnimal.infrastructure.primary;

import java.time.LocalDateTime;

public record UpdateUserAnimalRequest(
    Long id,
    Long damage,
    String name,
    String image,
    LocalDateTime creationAt,
    LocalDateTime updatedAt,
    Long userId
) {
}
