package com.example.jeezoo.zoo.infrastructure.primary.response;

import com.example.jeezoo.playerAnimal.infrastructure.primary.PlayerAnimalResponse;
import com.example.jeezoo.zoo.domain.Zoo;
import lombok.Data;

import java.time.LocalDateTime;

@Data(staticConstructor = "of")
public class ZooDetailsResponse {

    private final Long id;
    private final String name;
    private final String zooStatus;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final Long playerId;

    private final Long killNumber;
    private final Long completedSpacesNumber;
    private final PlayerAnimalResponse playerAnimal;

    public static ZooDetailsResponse fromZoo(
        Zoo zoo, Long killNumber, Long completedSpacesNumber,
        PlayerAnimalResponse playerAnimalResponse
    ) {
        return new ZooDetailsResponse(
            zoo.getId().getValue(),
            zoo.getName(),
            zoo.getZooStatus().name(),
            zoo.getCreatedAt(),
            zoo.getUpdatedAt(),
            zoo.getPlayerId().getValue(),
            killNumber,
            completedSpacesNumber,
                playerAnimalResponse
        );
    }
}
