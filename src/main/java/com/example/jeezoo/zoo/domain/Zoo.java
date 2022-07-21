package com.example.jeezoo.zoo.domain;

import com.example.jeezoo.player.domain.model.PlayerId;
import lombok.Data;

import java.time.LocalDateTime;

@Data(staticConstructor = "of")
public class Zoo {

    private final ZooId id;
    private final String name;
    private final ZooStatus zooStatus;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final PlayerId playerId;

    public static Zoo createZoo(String name, ZooStatus zooStatus, PlayerId playerId) {
        return new Zoo(
            ZooId.notCreatedYet(),
            name,
            zooStatus,
            LocalDateTime.now(),
            LocalDateTime.now(),
                playerId
        );
    }
}
