package com.example.jeezoo.userAnimal.infrastructure.primary;

import com.example.jeezoo.userAnimal.domain.UserAnimal;

import java.time.LocalDateTime;

public record UserAnimalResponse(
    Long id,
    Long damage,
    String name,
    String image,
    LocalDateTime creationAt,
    LocalDateTime updatedAt,
    Long userId,
    Long zooId
) {
    public static UserAnimalResponse fromUserAnimal(UserAnimal userAnimal) {
        return new UserAnimalResponse(
            userAnimal.getId().getValue(),
            userAnimal.getDamage().getValue(),
            userAnimal.getName(),
            userAnimal.getImage(),
            userAnimal.getCreationAt(),
            userAnimal.getUpdatedAt(),
            userAnimal.getUserId().getValue(),
            userAnimal.getZooId().getValue()
        );
    }
}
