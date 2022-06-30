package com.example.jeezoo.userAnimal.infrastructure.primary;

import com.example.jeezoo.user.domain.model.UserId;
import com.example.jeezoo.userAnimal.domain.UserAnimal;
import com.example.jeezoo.userAnimal.domain.UserAnimalDamage;
import com.example.jeezoo.userAnimal.domain.UserAnimalId;

import java.time.LocalDateTime;

public record UserAnimalResponse(
    Long id,
    Long damage,
    String name,
    String image,
    LocalDateTime creationAt,
    LocalDateTime updatedAt,
    Long userId
) {
    public static UserAnimalResponse fromUserAnimal(UserAnimal userAnimal) {
        return new UserAnimalResponse(
            userAnimal.getUserId().getValue(),
            userAnimal.getDamage().getValue(),
            userAnimal.getName(),
            userAnimal.getImage(),
            userAnimal.getCreationAt(),
            userAnimal.getUpdatedAt(),
            userAnimal.getUserId().getValue()
        );
    }
}
