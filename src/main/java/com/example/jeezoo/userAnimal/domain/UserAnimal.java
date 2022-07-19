package com.example.jeezoo.userAnimal.domain;

import com.example.jeezoo.user.domain.model.UserId;
import lombok.Data;

import java.time.LocalDateTime;

@Data(staticConstructor = "of")
public final class UserAnimal {

    private final UserAnimalId id;
    private final UserAnimalDamage damage;
    private final String name;
    private final String image;
    private final LocalDateTime creationAt;
    private final LocalDateTime updatedAt;
    private final UserId userId;

    public static UserAnimal create(
        String name,
        String image,
        UserId userId
    ) {
        return new UserAnimal(
            UserAnimalId.create(),
            UserAnimalDamage.create(),
            name,
            image,
            LocalDateTime.now(),
            LocalDateTime.now(),
            userId
        );
    }
}