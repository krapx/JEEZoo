package com.example.jeezoo.playerAnimal.domain;

import com.example.jeezoo.player.domain.model.PlayerId;
import com.example.jeezoo.zoo.domain.ZooId;
import lombok.Data;

import java.time.LocalDateTime;

@Data(staticConstructor = "of")
public final class PlayerAnimal {

    private final PlayerAnimalId id;
    private final PlayerAnimalDamage damage;
    private final String name;
    private final String image;
    private final LocalDateTime creationAt;
    private final LocalDateTime updatedAt;
    private final PlayerId playerId;
    private final ZooId zooId;

    public static PlayerAnimal create(
        String name,
        String image,
        PlayerId playerId,
        ZooId zooId
    ) {
        return new PlayerAnimal(
            PlayerAnimalId.notCreatedYet(),
            PlayerAnimalDamage.notCreateYet(),
            name,
            image,
            LocalDateTime.now(),
            LocalDateTime.now(),
                playerId,
            zooId
        );
    }
}
